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
        while (timeRemaining > 0)
        {
            tick();
        }
        timesUp = true;
    }


    public void tick()
    {
        timeRemaining--;
    }

    public void timeWarning()
    {

    }

    public boolean isTimeUp()
    {
        return timesUp;
    }
}
