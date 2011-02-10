﻿/*
Copyright (C) 2008 by:
    Stephen Damm
    Greg Logan
    Kyle Fisher
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer in the
      documentation and/or other materials provided with the distribution.
    * Neither the name of the <organization> nor the
      names of its contributors may be used to endorse or promote products
      derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;

namespace IlluminatrixEngine.Framework.Effects
{
    public class ScreenPopup : ScreenEffect
    {
        private String _text;

        /// <summary>
        /// Public constructor
        /// </summary>
        /// <param name="offTimeInSecond"></param>
        /// <param name="onTimeInSecond"></param>
        public ScreenPopup(String text, float offTimeInSecond, float onTimeInSecond) : 
            base(offTimeInSecond, onTimeInSecond)
        {
            _text = text;
        }

        /// <summary>
        /// Gets the current alpha of the screen transition, ranging
        /// from 255 (fully active, no transition) to 0 (transitioned
        /// fully off to nothing).
        /// </summary>
        public byte TransitionAlpha
        {
            get { return (byte)(255 - TransitionPosition * 255); }
        }


        /// <summary>
        /// Simply call the engines fade for now
        /// </summary>
        public override void draw()
        {
            // create the text
            ScreenText text = new ScreenText(Engine.MenuFont, _text, 1.0f, 1.0f);
            ScreenFade fade = new ScreenFade(0.75f, 0.75f);

            //popup rect
            Rectangle rect = new Rectangle();
            rect.Width = (int)( (Engine.GraphicsDevice.Viewport.Width * 0.75f) * TransitionPosition);
            rect.Height = (int)text.GetSize().Y;// (int)(Engine.GraphicsDevice.Viewport.Height * 0.35f);

            // resize if the text is HUGE
            rect.Width = (int)(Math.Max(rect.Width, (text.GetSize().X*1.05) * TransitionPosition));
            rect.Height = (int)(Math.Max(rect.Height, text.GetSize().Y));

            // position the rect
            rect.X = (Engine.GraphicsDevice.Viewport.Width / 2) - (rect.Width / 2);
            rect.Y = (Engine.GraphicsDevice.Viewport.Height / 2) - (rect.Height / 2);

            // draw popup window
            Engine.SpriteBatch.Begin();
            Engine.SpriteBatch.Draw(Engine.BlankTexture, rect, new Color(Color.DarkBlue, (byte)175));
            Engine.SpriteBatch.End();

            // text rect
            if (this.isComplete())
            {
                text.Color = Color.Wheat;
                text.Position.X = (rect.X + rect.Width / 2) - (text.GetSize().X / 2); ;
                text.Position.Y = (rect.Y);

                // draw text
                text.draw();
            }
        }
    }
}
