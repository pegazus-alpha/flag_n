package com.example.flag;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class Inf111 extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView recyclerView1;
    AdaptCours adaptCours;
    chap_adapter adapter;
    List<chap_model> list;
    List<String> list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inf_cent_onze);
        recyclerView=findViewById(R.id.recycler);
        recyclerView1=findViewById(R.id.recycler1);
        list=new ArrayList<>();
        list1=new ArrayList<>();
        //list.add(new chap_model("a","a","a"));
        adapter=new chap_adapter(list);
        adaptCours=new AdaptCours(list1);
        FirebaseStorage storage=FirebaseStorage.getInstance();
        StorageReference storageReference= storage.getReferenceFromUrl("gs://my-flags.appspot.com");
        StorageReference itemRef1=storageReference.child("INFO/INFO1/semestre1/INF 111/");
        StorageReference itemRef2=storageReference.child("INFO/INFO1/semestre1/INF111_exos/");
        dynamic(recyclerView,adapter,list,itemRef1);
        dynamic2(recyclerView1,adaptCours,list1,itemRef2);

        animateFirst();
        animateSecond();
        animateThird();
        Button read= findViewById(R.id.button2);



        /*read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Inf111.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });*/


    }
    private void animateFirst(){
        View disc=findViewById(R.id.idanim);
        AnimationSet sloganAnimation=(AnimationSet) AnimationUtils.loadAnimation(this,R.anim.haut_animation);
        disc.startAnimation(sloganAnimation);
    }
    private void animateSecond(){
        View im=findViewById(R.id.view);
        AnimationSet sloganAnimation=(AnimationSet) AnimationUtils.loadAnimation(this,R.anim.haut_animation);
        im.startAnimation(sloganAnimation);
    }
    private void animateThird(){
        View who=findViewById(R.id.textView11);
        AnimationSet sloganAnimation=(AnimationSet) AnimationUtils.loadAnimation(this,R.anim.haut_animation);
        who.startAnimation(sloganAnimation);
    }
    //dynamisation de la page
    public void dynamic(RecyclerView recyclerView, chap_adapter adapter,List<chap_model> list,StorageReference itemRef){



        itemRef.listAll().addOnSuccessListener(listResult -> {
            for(StorageReference itemRe:listResult.getPrefixes()){
                String chap=itemRe.getName();
                chap_model c=new chap_model(chap,chap,chap);
                System.out.println(chap);

                list.add(c);
            }
            adapter.setChap_list(list);
            adapter.notifyDataSetChanged();
            //adapter=new chap_adapter(list);
        }).addOnFailureListener(e->{
            //errueur
            Log.e("Firebase", "Erreur lors de la récupération des données", e);
            Toast.makeText(this, "Erreur lors de la récupération des données", Toast.LENGTH_SHORT).show();
        });



        //adapter=new chap_adapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        Log.e("tag",""+adapter.getItemCount());
    }
    public void dynamic2(RecyclerView recyclerView1,AdaptCours adaptCours,List<String> exo,StorageReference itemRef1){
        itemRef1.listAll().addOnSuccessListener(listResult -> {
            for(StorageReference itemRe:listResult.getPrefixes()){
                String chap=itemRe.getName();
                exo.add(chap);
                adaptCours.notifyDataSetChanged();
            }
            //exo.add("iiikiiiii");
            Log.e("tag",""+exo.size());
            adaptCours.setCours(exo);
            adaptCours.notifyDataSetChanged();
        }).addOnFailureListener(e->{
            Log.e("Firebase", "Erreur lors de la récupération des données", e);
            Toast.makeText(this, "Erreur lors de la récupération des données", Toast.LENGTH_SHORT).show();
        });
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.setAdapter(adaptCours);
    }
}
