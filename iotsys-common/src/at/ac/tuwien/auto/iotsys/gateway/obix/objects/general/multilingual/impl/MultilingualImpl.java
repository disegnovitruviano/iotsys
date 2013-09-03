/*******************************************************************************
 * Copyright (c) 2013
 * Institute of Computer Aided Automation, Automation Systems Group, TU Wien.
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. Neither the name of the Institute nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE INSTITUTE AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED.  IN NO EVENT SHALL THE INSTITUTE OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * 
 * This file is part of the IoTSyS project.
 ******************************************************************************/

package at.ac.tuwien.auto.iotsys.gateway.obix.objects.general.multilingual.impl;

import java.util.ArrayList;

import obix.Contract;
import obix.List;
import obix.Obj;
import obix.Uri;
import at.ac.tuwien.auto.iotsys.gateway.obix.objects.general.multilingual.Multilingual;
import at.ac.tuwien.auto.iotsys.gateway.obix.objects.general.multilingual.Translation;

public abstract class MultilingualImpl extends Obj implements Multilingual
{
	private List list = null;
	protected ArrayList<Translation> translations;
	private int translationCount = 0;

	public void addTranslation(TranslationImpl translation)
	{
		if (translations == null)
		{
			this.list = new List("translations", new Contract("knx:translation"));
			this.list.setHref(new Uri("translations"));
			this.add(this.list);

			this.translations = new ArrayList<Translation>();
		}
		
		translation.setHref(new Uri(String.valueOf(++translationCount)));
		
		this.list.add(translation);
		this.translations.add(translation);
	}

	@Override
	public String getTranslation(String language, String attribute)
	{
		if (translations != null)
		{
			for (Translation t : this.translations)
			{
				if (t.getLanguage().equals(language) && t.getAttribute().equals(attribute))
				{
					return t.getValue();
				}
			}
		}
		return null;
	}
}
