package com.ngaoudere.vpn;

import android.content.Intent;
import android.net.VpnService;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnConnect;
    private TextView tvStatus;
    private boolean isConnected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConnect = findViewById(R.id.btn_connect);
        tvStatus = findViewById(R.id.tv_status);

        btnConnect.setOnClickListener(v -> {
            if (!isConnected) {
                Intent intent = VpnService.prepare(this);
                if (intent != null) {
                    startActivityForResult(intent, 0);
                } else {
                    startVpn();
                }
            } else {
                stopVpn();
            }
        });
    }

    private void startVpn() {
        Intent intent = new Intent(this, VpnService.class);
        startService(intent);
        isConnected = true;
        btnConnect.setText("Déconnecter");
        tvStatus.setText("Connecté");
    }

    private void stopVpn() {
        Intent intent = new Intent(this, VpnService.class);
        stopService(intent);
        isConnected = false;
        btnConnect.setText("Connecter");
        tvStatus.setText("Déconnecté");
    }
}
