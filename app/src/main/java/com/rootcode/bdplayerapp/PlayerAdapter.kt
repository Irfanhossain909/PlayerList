package com.rootcode.bdplayerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class PlayerAdapter (private val playerList:List<PlayerModel>,private val clickListener:(PlayerModel)->Unit):RecyclerView.Adapter<MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val PlayerItem = layoutInflater.inflate(R.layout.player_1,parent,false)
        return MyViewHolder(PlayerItem)
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val player = playerList[position]
        holder.bind(player, clickListener)
    }
}

class MyViewHolder(val view:View):RecyclerView.ViewHolder(view) {
    fun bind(player:PlayerModel, clickListener: (PlayerModel) -> Unit){
        val name = view.findViewById<TextView>(R.id.P1Name)
        val position = view.findViewById<TextView>(R.id.P1position)
        val image = view.findViewById<CircleImageView>(R.id.P1Img)

        name.text = player.name
        position.text = player.Position
        image.setImageResource(player.Image)

        view.setOnClickListener{
            clickListener(player)
        }

    }

}
