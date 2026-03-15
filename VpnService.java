package com.ngaoudere.vpn;

import android.net.VpnService;
import android.os.ParcelFileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class VpnService extends VpnService {
    private ParcelFileDescriptor vpnInterface;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && "stop".equals(intent.getAction())) {
            stopVpn();
            return START_NOT_STICKY;
        }
        startVpn();
        return START_STICKY;
    }

    private void startVpn() {
        Builder builder = new Builder();
        builder.addAddress("10.0.0.2", 24);
        builder.addDnsServer("8.8.8.8");
        builder.addRoute("0.0.0.0", 0);
        vpnInterface = builder.establish();
        // Gérer les flux ici
    }

    private void stopVpn() {
        if (vpnInterface != null) {
            try {
                vpnInterface.close();
            } catch (Exception e) {}
        }
    }
}
