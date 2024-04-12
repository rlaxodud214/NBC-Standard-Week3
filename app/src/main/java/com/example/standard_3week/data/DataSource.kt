package com.example.standard_3week.data

class DataSource {
    fun getFlowerList(): List<Flower> {
        return flowerList()
    }

    companion object {
        private var INSTANCE: DataSource? = null

        fun getDataSource(): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource()

                if (INSTANCE == null) {
                    INSTANCE = newInstance
                }

                newInstance
            }
        }
    }
}