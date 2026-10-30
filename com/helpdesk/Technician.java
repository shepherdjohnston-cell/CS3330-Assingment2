package com.helpdesk;

public class Technician {
    private final String name;
    private int servicePoints;

    public Technician(String name) {
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }

        this.name = name;
        this.servicePoints = 0;
    }

    public void addPoints(int amount){
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }

        servicePoints = servicePoints + amount;
    }

    public String getName(){
        return name;
    }

    public int getServicePoints(){
        return servicePoints;
    }

    @Override
    public String toString(){
        return String.format("Technician Name: %s | Points: %d", name, servicePoints);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Technician)){
            return false;
        }

        Technician other = (Technician) obj;

        return this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
