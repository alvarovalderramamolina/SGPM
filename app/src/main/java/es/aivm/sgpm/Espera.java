package es.aivm.sgpm;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class Espera extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espera);
        hideNavigationBar();
        WebView videoWeb = (WebView) findViewById(R.id.videoWebView);
        VideoEspera video = new VideoEspera("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/EXcHlh8qFVg\" frameborder=\"0\" allowfullscreen></iframe>");
        videoWeb.getSettings().setJavaScriptEnabled(true);
        videoWeb.setWebChromeClient(new WebChromeClient());
        videoWeb.loadData(video.getVideoUrl(),"text/html","utf-8");

        final TextView countText = (TextView) findViewById(R.id.timer);
        new CountDownTimer(90000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                long minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished);
                long seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)%60;
                String timeLeftText;
                timeLeftText = ""+minutes;
                timeLeftText += ":";
                if(seconds<10)
                    timeLeftText+="0";
                timeLeftText += seconds;
                countText.setText(timeLeftText);
            }

            @Override
            public void onFinish() {

            }
        }.start();

    }
    private void hideNavigationBar() {
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );
    }
}