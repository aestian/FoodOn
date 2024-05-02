package my.foodon.app.customerFoodPanel;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import my.foodon.app.R;

public class ViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView Dishname, Price;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.menu_image);
        Dishname = itemView.findViewById(R.id.dishname);
        Price = itemView.findViewById(R.id.dishprice);
    }
}
