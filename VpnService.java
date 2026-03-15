String config = "vless://39382039-3720-4438-a039-392035332035@tr-1.stunnel.cc:8442?...";
V2Ray.init(this);
V2Ray.setConfig(config);
V2Ray.start();
// Ajoute V2Ray core
import com.v2ray.ang.V2Ray;

public class VpnService extends VpnService {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        V2Ray.init(this);
        V2Ray.start();
        // ...
    }
    // Ajoute V2Ray core
import com.v2ray.ang.V2Ray;

public class VpnService extends VpnService {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        V2Ray.init(this);
        V2Ray.start();
        // ...
    }
}
}
