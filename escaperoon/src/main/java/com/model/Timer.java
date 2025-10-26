package com.model;

public class Timer 
{
    private int duration;
    private int timeRemaining;
    private boolean timesUp;

    /*
     * Constructs a new timer with a specified duration 
     */
    public Timer(int duration)
    {
        this.duration = duration;
        this.timeRemaining = duration;
        this.timesUp = false;
    }

    /*
     * Starts or resets the timer 
     */
    public void start()
    {
       this.timeRemaining = duration; 
       this.timesUp = false;
    }

    /*
     * Decreases the remaining time by one second 
     */
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

    /*
     * Returns whether the time is up or not 
     */
    public boolean isTimeUp()
    {
        return timesUp;
    }

    /*
     * Stops the timer 
     * Sets time remaining to 0 
     */
    public void stop()
    {
        if(!timesUp)
        {
            timesUp = true;
            timeRemaining = 0;
        }
    }
}
