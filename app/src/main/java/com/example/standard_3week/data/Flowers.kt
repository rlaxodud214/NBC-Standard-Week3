package com.example.standard_3week.data

import com.example.standard_3week.R

fun flowerList(): List<Flower> {
    val imageResource = listOf(
        R.drawable.img_post1,
        R.drawable.img_post2,
        R.drawable.img_post3,
        R.drawable.img_post4,
        R.drawable.img_post5,
    )

    return List(5) {
        Flower(
            id = it,
            name = "dog $it",
            image = imageResource[it % 10],
            description = "Info $it"
        )
    }
}
