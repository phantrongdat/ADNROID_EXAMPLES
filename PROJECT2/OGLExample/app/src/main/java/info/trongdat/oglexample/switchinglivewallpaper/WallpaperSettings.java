package info.trongdat.oglexample.switchinglivewallpaper;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import info.trongdat.oglexample.R;

public class WallpaperSettings extends PreferenceActivity {
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);
	}	
}
