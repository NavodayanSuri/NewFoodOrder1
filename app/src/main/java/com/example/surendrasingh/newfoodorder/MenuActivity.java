package com.example.surendrasingh.newfoodorder;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MenuActivity extends AppCompatActivity {
    RecyclerView mfoodlist;
    FirebaseAuth mauth;
    DatabaseReference mdatabase;
    FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mfoodlist=(RecyclerView)findViewById(R.id.foodlist);
        mfoodlist.setHasFixedSize(true);
        mfoodlist.setLayoutManager(new LinearLayoutManager(this));
        mauth=FirebaseAuth.getInstance();
        mdatabase= FirebaseDatabase.getInstance().getReference().child("Item");

        mAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser()==null)
                {
                    startActivity(new Intent(MenuActivity.this,MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));

                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
          mauth.addAuthStateListener(mAuthListener);
        FirebaseRecyclerAdapter<food,foodviewfolder> FBRA= new FirebaseRecyclerAdapter<food, foodviewfolder>() {
            @Override
            protected void populateViewHolder(foodviewfolder viewHolder, food model, int position) {

            }
        };
    }
    public static class foodviewholder extends RecyclerView.ViewHolder{
        View mview;
        public foodviewholder(View itemView) {
            super(itemView);
            mview=itemView;

        }
        public void setName(String name) {
            TextView food_name=(TextView)mview.findViewById(R.id.foodname);
            food_name.setText(name);
        }

        public void setPrize(String prize) {
            TextView prz=(TextView)mview.findViewById(R.id.prize);
            prz.setText(prize);
        }

        public void setImage(Context ctx,String image) {
            this.image = image;
        }

        public void setDesc(String desc) {
            TextView decr=(TextView)mview.findViewById(R.id.fooddec);
            decr.setText(desc);
        }
    }
}

