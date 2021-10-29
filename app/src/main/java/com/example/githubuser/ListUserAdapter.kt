package com.example.githubuser

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.githubuser.databinding.ItemRowGithubUserBinding

class ListUserAdapter(private val listUser : ArrayList<User>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {
    inner class ListViewHolder(private var binding: ItemRowGithubUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user : User){
            with(binding){
                tvName.text = user.name
                tvUsername.text = user.username
                tvCompany.text = user.company
                Glide.with(itemView.context)
                    .load(user.avatar)
                    .into(imgProfile)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context,DetailUser::class.java)
                    intent.putExtra(DetailUser.EXTRA_USER,user)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowGithubUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listUser[position])

    }

    override fun getItemCount(): Int {
        return listUser.size
    }
}