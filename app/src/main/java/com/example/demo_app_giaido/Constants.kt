package com.example.demo_app_giaido

object Constants{

    fun getQuestions(): ArrayList<Questions>{
        val questionsList = ArrayList<Questions>()

        val que1 = Questions(
            1,
            "What is this animal?",
            R.drawable.cho,
            "Dog",
            "Cat",
            "Rabbit",
            "deer",
            1
        )
        questionsList.add(que1)

        //2
        val que2 = Questions(
            2,
            "What is this animal?",
            R.drawable.meo,
            "Deer",
            "Lion",
            "Cat",
            "Chicken",
            3
        )
        questionsList.add(que2)

        //3
        val que3 = Questions(
            3,
            "What is this animal?",
            R.drawable.tho,
            "Rabbit",
            "Elephants",
            "Deer",
            "Bird",
            1
        )
        questionsList.add(que3)

        //4
        val que4 = Questions(
            4,
            "What is this animal?",
            R.drawable.vit,
            "Rabbit",
            "Elephants",
            "Chicken",
            "Duck",
            4
        )
        questionsList.add(que4)

        //5
        val que5 = Questions(
            5,
            "What is this animal?",
            R.drawable.chim,
            "Rabbit",
            "Bird",
            "Wolf",
            "Duck",
            2
        )
        questionsList.add(que5)

        //6
        val que6 = Questions(
            6,
            "What is this animal?",
            R.drawable.ho,
            "Wolf",
            "Lion",
            "Tiger",
            "Bird",
            3
        )
        questionsList.add(que6)

        //3
        val que7 = Questions(
            7,
            "What is this animal?",
            R.drawable.voi,
            "Rabbit",
            "Elephants",
            "Lion",
            "Duck",
            2
        )
        questionsList.add(que7)

        //3
        val que8 = Questions(
            8,
            "What is this animal?",
            R.drawable.ga,
            "Lion",
            "Rabbit",
            "Chicken",
            "Bird",
            3
        )
        questionsList.add(que8)

        //3
        val que9 = Questions(
            9,
            "What is this animal?",
            R.drawable.soi,
            "Wolf",
            "Rabbit",
            "Chicken",
            "Duck",
            1
        )
        questionsList.add(que9)

        //3
        val que10 = Questions(
            10,
            "What is this animal?",
            R.drawable.sutu,
            "Chicken",
            "Elephants",
            "Rabbit",
            "Lion",
            4
        )
        questionsList.add(que10)

        return questionsList
    }

}