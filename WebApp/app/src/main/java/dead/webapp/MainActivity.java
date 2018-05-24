package dead.webapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    WebView simplewebview;
    EditText HTTP;
    Button Go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        simplewebview=findViewById(R.id.Web_View);
        HTTP=findViewById(R.id.HTTP);

        simplewebview.getSettings().setJavaScriptEnabled(true);
        Go=findViewById(R.id.GO);

        simplewebview.setWebViewClient(new CustomWebClientServer());
        Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url=HTTP.getText().toString();
                url="http://"+url;



                try {
                    new URL(url); //used to check exception
                    simplewebview.loadUrl(url);

                } catch (MalformedURLException e) {
                    Toast.makeText(MainActivity.this,"Enter Correct URL",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.back) {
            if (simplewebview.canGoBack())
                simplewebview.goBack();
            return true;
        }
        if (id==R.id.Forward){
            if (simplewebview.canGoForward())
                simplewebview.goForward();
        }


        return super.onOptionsItemSelected(item);
    }
}
