/*******************************************************************************
 * Copyright (c) 2013, Automation Systems Group, TU Wien.
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

package at.ac.tuwien.auto.iotsys.gateway.obix.objects.general.enumeration;

import obix.contracts.Range;

public interface EnumLanguage extends Range
{
	public static final String HREF = "/enums/enumLanguage";
	
	public static final String en_EN = "en-EN";
	
	public static enum Enum
	{
		en_EN("en-EN", "English"),
		de_DE("de-DE", "German"),
		it_IT("it-IT", "Italian"),
		es_ES("es-ES", "Spanish"),
		en_US("en-US", "English (United States)"),
		fr_FR("fr-FR", "French"),
		id_ID("id-ID", "Indonesian"),
		nb_NO("nb-NO", "Norwegian"),
		sv_SE("sv-SE", "Swedish"),
		da_DK("da-DK", "Danish"),
		nl_NL("nl-NL", "Dutch"),
		el_GR("el-GR", "Greek"),
		ru_RU("ru-RU", "Russian");
		
		private String key;
		private String name;
		
		private Enum(String key, String name)
		{
			this.key = key;
			this.name = name;
		}
		
		public String getName()
		{
			return name;
		}
		
		public String getKey()
		{
			return key;
		}
		
		public Enum getLanguage(String key)
		{
			for(Enum l : Enum.values())
			{
				if (l.key.toLowerCase().equals(key.toLowerCase()))
				{
					return l;
				}
			}
			return null;
		}
	}
}
