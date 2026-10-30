package com.helpdesk;

public class DeviceSetupRequest extends AbstractSupportRequest {
    private final int deviceCount;

    public DeviceSetupRequest(int id, String title, int basePoints, int deviceCount){
        super(id, title, basePoints);

        if (deviceCount <= 0){
            throw new IllegalArgumentException("Device count must be positive.");
        }

        this.deviceCount = deviceCount;
    }

    @Override
    public int resolveFor(Technician technician){
        markResolved();

        int points = getBasePoints() * deviceCount;
        technician.addPoints(points);
        return points;
    }

    public int getDeviceCount(){
        return deviceCount;
    }
}
