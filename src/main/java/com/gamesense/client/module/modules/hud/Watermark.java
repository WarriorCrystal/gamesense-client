package com.gamesense.client.module.modules.hud;

import java.awt.Color;
import java.awt.Point;

import com.gamesense.api.settings.Setting;
import com.gamesense.api.util.render.GSColor;
import com.gamesense.client.GameSenseMod;
import com.lukflug.panelstudio.hud.HUDList;
import com.lukflug.panelstudio.hud.ListComponent;
import com.lukflug.panelstudio.theme.Theme;

// PanelStudio rewrite by lukflug
public class Watermark extends HUDModule {
	private Setting.ColorSetting color;
	
	public Watermark() {
		super("Watermark",new Point(0,0));
	}
	
	public void setup() {
		color=registerColor("Color", "Color", new GSColor(255, 0, 0, 255));
	}
	
	@Override
	public void populate (Theme theme) {
		component=new ListComponent(getName(),theme.getPanelRenderer(),position,new WatermarkList());
	}
	
	
	private class WatermarkList implements HUDList {
		@Override
		public int getSize() {
			return 1;
		}

		@Override
		public String getItem(int index) {
			return "GameSense "+GameSenseMod.MODVER;
		}

		@Override
		public Color getItemColor(int index) {
			return color.getValue();
		}

		@Override
		public boolean sortUp() {
			return false;
		}

		@Override
		public boolean sortRight() {
			return false;
		}
	}
}
