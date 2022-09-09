package com.example.demo_app_giaido

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.demo_app_giaido.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

//    var tv_question = findViewById<TextView>(R.id.tv_question)
//    var iv_image = findViewById<ImageView>(R.id.iv_image)
//    var tvOption_1 = findViewById<TextView>(R.id.tvOption_1)
//    var tvOption_2 = findViewById<TextView>(R.id.tvOption_2)
//    var tvOption_3 = findViewById<TextView>(R.id.tvOption_3)
//    var tvOption_4 = findViewById<TextView>(R.id.tvOption_4)

    private lateinit var tv_question: TextView
    private lateinit var tvOption_1: TextView
    private lateinit var tvOption_2: TextView
    private lateinit var tvOption_3: TextView
    private lateinit var tvOption_4: TextView
    private lateinit var tv_Submit: TextView
    private lateinit var iv_image: ImageView

    private var mCurrentPosition : Int = 1
    private var mQuestionsList : ArrayList<Questions>? = null
    private var mSelectedOpionPositio : Int = 0


//    private lateinit var binding: ActivityQuizQuestionsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

//        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        binding.tvOption1.text = questions!!.optionOne
//       binding.tvQuestion.text = "asdasdadsasd"



        mQuestionsList = Constants.getQuestions()

        tv_question = findViewById(R.id.tv_question)
        tvOption_1 = findViewById(R.id.tvOption_1)
        tvOption_2 = findViewById(R.id.tvOption_2)
        tvOption_3 = findViewById(R.id.tvOption_3)
        tvOption_4 = findViewById(R.id.tvOption_4)
        tv_Submit = findViewById(R.id.tv_Submit)
        iv_image = findViewById(R.id.iv_image)

        setQuestion()

        tvOption_1.setOnClickListener(this)
        tvOption_2.setOnClickListener(this)
        tvOption_3.setOnClickListener(this)
        tvOption_4.setOnClickListener(this)

        tv_Submit.setOnClickListener(this)

    }

    private fun setQuestion(){


        val questions = mQuestionsList!![mCurrentPosition-1]

        defaultOptionsView()

        if (mCurrentPosition == mQuestionsList!!.size){
            tv_Submit.text = "FINISH"
        }else{
            tv_Submit.text = "SUBMIT"
        }

        tv_question.text = questions!!.question
        iv_image.setImageResource(questions.image)
        tvOption_1.text = questions!!.optionOne
        tvOption_2.text = questions!!.optionTwo
        tvOption_3.text = questions!!.optionThree
        tvOption_4.text = questions!!.optionFour
    }

    private fun defaultOptionsView(){

        val options = ArrayList<TextView>()
        options.add(0, tvOption_1)
        options.add(1, tvOption_2)
        options.add(2, tvOption_3)
        options.add(3, tvOption_4)

        for (option in options){
            option.setTextColor(Color.parseColor("#808080"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.select_opsions_boder
            )

        }



    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tvOption_1 ->{
                selectOptionView(tvOption_1,1)
            }
            R.id.tvOption_2 ->{
                selectOptionView(tvOption_2,2)
            }
            R.id.tvOption_3 ->{
                selectOptionView(tvOption_3,3)
            }
            R.id.tvOption_4 ->{
                selectOptionView(tvOption_4,4)
            }
            R.id.tv_Submit ->{
                if (mSelectedOpionPositio == 0){
                    mCurrentPosition ++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            setQuestion()
                        }else->{

                        val intent = Intent(this, InappActivity :: class.java)
                        startActivity(intent)

                            Toast.makeText(this, "you have successfully completed thr Quiz",
                            Toast.LENGTH_LONG).show()
                        }
                    }
                } else{
                    val question = mQuestionsList?.get(mCurrentPosition -1)
                    if (question!!.correctAnswer != mSelectedOpionPositio){
                        answerView(mSelectedOpionPositio, R.drawable.wrong_option_boder)
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_boder)

                    if (mCurrentPosition == mQuestionsList!!.size){
                        tv_Submit.text = "FINISH"
                    }else{
                        tv_Submit.text = " GO TO NEXT QUESTION"
                    }
                    mSelectedOpionPositio = 0

                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                tvOption_1.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                tvOption_2.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                tvOption_3.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                tvOption_4.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }

    private fun selectOptionView(tv: TextView, selectOptionNum: Int){

        defaultOptionsView()
        mSelectedOpionPositio = selectOptionNum

        tv.setTextColor(Color.parseColor("#000000"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.select_opsions_boder
        )
    }



}