package com.model;

public class Timer 
{
    private int duration;
    private int timeRemaining;
    private boolean timesUp;

    public Timer(int duration)
    {
        this.duration = duration;
        this.timeRemaining = duration;
        this.timesUp = false;
    }

    public void start()
    {
       this.timeRemaining = duration; 
       this.timesUp = false;
    }


    public void tick()
    {
        if(timesUp)
        {
            return;
        }

        if (timeRemaining > 0)
        {
            timeRemaining--;

            timeWarning();

            if(timeRemaining == 0)
            {
                timesUp = true;
            }
        }
    }

    public void timeWarning()
    {

    }

    public boolean isTimeUp()
    {
        return timesUp;
    }

    public void stop()
    {
        if(!timesUp)
        {
            timesUp = true;
            timeRemaining = 0;
        }
    }
}
