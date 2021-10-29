package com.example.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.githubuser.databinding.ActivityDetailUserBinding

class DetailUser : AppCompatActivity() {
    private lateinit var binding : ActivityDetailUserBinding

    companion object{
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User
        with(binding){
            tvName.text = user.name
            tvUsername.text = user.username
            tvFollower.text = getString(R.string.follower,user.followers)
            tvFollowing.text = getString(R.string.following,user.following)
            tvRepository.text = getString(R.string.repository,user.repository)
            tvCompany.text = user.company
            tvLocation.text = user.location
            Glide
                .with(this@DetailUser)
                .load(user.avatar)
                .into(imgProfile)
        }

        supportActionBar?.title = "Detail User"
    }
}