package entity;

import entity.types.AbilityState;

public class Pair {

    AbilityState status;
    Integer priority;

    public Pair(AbilityState status, Integer priority){
        this.status = status;
        this.priority = priority;

    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public AbilityState getStatus() {
        return status;
    }

    public void setStatus(AbilityState status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "status=" + status.name() +
                ", priority=" + priority +
                '}';
    }
}
