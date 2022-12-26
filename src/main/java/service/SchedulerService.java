package service;

import java.util.TimerTask;

public class SchedulerService extends TimerTask {

    private SafeDecMediator mediator;

    public SchedulerService(SafeDecMediator mediator){
        this.mediator = mediator;
    }

    @Override
    public void run() {
        toggleService();
    }

    public void toggleService() {
        if (mediator.isServiceActivated) {
            mediator.service.deactivateService();
            mediator.isServiceActivated = false;
        }
        else {
            mediator.service.activateService();
            mediator.isServiceActivated = true;
        }
    }

}
