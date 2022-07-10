//package com.sda.projet.chant.model.adapteur.recyclerview;
//
//import android.content.Context;
//import android.text.Html;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.firebase.ui.database.FirebaseRecyclerAdapter;
//import com.firebase.ui.database.FirebaseRecyclerOptions;
//import com.sda.projet.MainModel;
//import com.sda.projet.R;
//
//public class NyimboAdapteur extends FirebaseRecyclerAdapter<MainModel, NyimboAdapteur.myViewHolder> {
//
//    Context context;
//
//    public NyimboAdapteur(@NonNull FirebaseRecyclerOptions<MainModel> options) {
//        super(options);
//    }
//
//
//
//    @Override
//    protected void onBindViewHolder(@NonNull NyimboAdapteur.myViewHolder holder, int position, @NonNull MainModel model) {
//        holder.numero.setText(Html.fromHtml(model.getNum()));
//        holder.titre.setText(Html.fromHtml(model.getTitre()));
//        holder.auteur.setText(Html.fromHtml(model.getAuteur()));
//        holder.contenu.setText(Html.fromHtml(model.getContenu()));
//
////        holder.itemView.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent gh = new Intent(context, MainActivity2.class);
////                gh.putExtra("pos",1);
////            }
////        });
//
////        holder.itemView.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////
////            }
////        });
//    }
//
//
//
//    @NonNull
//    @Override
//    public NyimboAdapteur.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.liste_chant,parent,false);
//        return new NyimboAdapteur.myViewHolder(view);
//    }
//
//    class  myViewHolder extends RecyclerView.ViewHolder{
//
//        TextView numero, titre, auteur, contenu;
//
//        public myViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            contenu = (TextView)itemView.findViewById(R.id.liste_conteu);
//            numero = (TextView)itemView.findViewById(R.id.liste_num);
//            titre = (TextView)itemView.findViewById(R.id.liste_titre);
//            auteur = (TextView)itemView.findViewById(R.id.liste_auteur);
//
//
//
//        }
//    }
//}
