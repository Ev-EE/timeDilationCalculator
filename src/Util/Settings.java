package Util;

public class Settings {

    private boolean chaosMode;
    private int musicVolume;

    public Settings()
    {
        chaosMode = false;
        musicVolume = 0;
    }

    public boolean isChaosMode()
    {
        return chaosMode;
    }

    public void changeChaosMode(boolean oldValue)
    {
        chaosMode = !oldValue;
    }


}
