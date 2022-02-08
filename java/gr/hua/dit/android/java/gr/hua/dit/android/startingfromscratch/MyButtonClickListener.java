package gr.hua.dit.android.startingfromscratch;

        import android.content.Context;
        import android.view.View;
        import android.widget.Toast;

        import androidx.annotation.NonNull;

public class MyButtonClickListener implements View.OnClickListener {

    private Context context;

    public MyButtonClickListener(Context c){
        this.context = c;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this.context,"Haha",Toast.LENGTH_SHORT).show();
    }
}
