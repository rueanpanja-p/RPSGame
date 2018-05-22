package com.rpskotlin.rpsgame2

import android.content.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.*
import android.content.Intent



class GameActivity : AppCompatActivity() {
    //Create by Pattanayu Rueanpanja 13580223
    var btn_rock: ImageButton? = null
    var btn_paper: ImageButton? = null
    var btn_scissors: ImageButton? = null
    var iv_human: ImageView? = null
    var iv_computer: ImageView? = null
    var rr = Random()
    var rule: Int = rr.nextInt(3)+1
    var tv_rule: TextView? = null
    var tv_score_human: TextView? = null
    var tv_score_computer: TextView? = null
    var humanScore: Int = 0
    var computerScore: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        btn_rock = findViewById(R.id.btn_rock)
        btn_paper = findViewById(R.id.btn_paper)
        btn_scissors = findViewById(R.id.btn_scissors)
        iv_human = findViewById(R.id.iv_human)
        iv_computer = findViewById(R.id.iv_computer)
        tv_rule = findViewById(R.id.tv_rule)
        tv_score_human = findViewById(R.id.tv_score_human)
        tv_score_computer = findViewById(R.id.tv_score_computer)

        if(rule == 1){
            tv_rule?.text = "Rule : Normal"
        }
        else if(rule == 2){
            tv_rule?.text = "Rule : Reverse!"
        }
        else if(rule == 3){
            tv_rule?.text = "Rule : Draw is a Friendship"
        }

        btn_rock?.setOnClickListener{
            iv_human?.setImageResource(R.drawable.rock_me)
            play_turn("rock")
        }

        btn_paper?.setOnClickListener{
            iv_human?.setImageResource(R.drawable.paper_me)
            play_turn("paper")
        }

        btn_scissors?.setOnClickListener{
            iv_human?.setImageResource(R.drawable.scissors_me)
            play_turn("scissors")
        }
    }
    fun random_rule(){
        rr = Random()
        rule = rr.nextInt(3)+1

        if(rule == 1){
            tv_rule?.text = "Rule : Normal"
        }
        else if(rule == 2){
            tv_rule?.text = "Rule : Reverse!"
        }
        else if(rule == 3){
            tv_rule?.text = "Rule : Draw is a Friendship"
        }
    }

    fun play_turn(your_choice:String){
        var computer_choice: String? = ""
        var r = Random()
        var computer_choice_number: Int = r.nextInt(3)+1

        if (computer_choice_number == 1){
            computer_choice = "rock"
        } else
            if (computer_choice_number == 2){
                computer_choice = "paper"
            } else
                if (computer_choice_number == 3){
                    computer_choice = "scissors"
                }

        if (computer_choice == "rock"){
            iv_computer?.setImageResource(R.drawable.rock_enemy)
        } else
            if (computer_choice == "paper"){
                iv_computer?.setImageResource(R.drawable.paper_enemy)
            } else
                if (computer_choice == "scissors"){
                    iv_computer?.setImageResource(R.drawable.scissors_enemy)
                }

        if(rule == 1){
            if (computer_choice == your_choice){
                Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show()
                random_rule()
            }
            else if(your_choice == "rock" && computer_choice == "scissors"){
                humanScore++
                tv_score_human?.text = "You : " + humanScore
                Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show()
                random_rule()
            }
            else if(your_choice == "paper" && computer_choice == "rock"){
                humanScore++
                tv_score_human?.text = "You : " + humanScore
                Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show()
                random_rule()
            }
            else if(your_choice == "scissors" && computer_choice == "paper"){
                humanScore++
                tv_score_human?.text = "You : " + humanScore
                Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show()
                random_rule()
            }
            else if(your_choice == "scissors" && computer_choice == "rock"){
                computerScore++
                tv_score_computer?.text = "Enemy : " + computerScore
                Toast.makeText(this, "You Lose!", Toast.LENGTH_SHORT).show()
                random_rule()
            }
            else if(your_choice == "rock" && computer_choice == "paper"){
                computerScore++
                tv_score_computer?.text = "Enemy : " + computerScore
                Toast.makeText(this, "You Lose!", Toast.LENGTH_SHORT).show()
                random_rule()
            }
            else if(your_choice == "paper" && computer_choice == "scissors"){
                computerScore++
                tv_score_computer?.text = "Enemy : " + computerScore
                Toast.makeText(this, "You Lose!", Toast.LENGTH_SHORT).show()
                random_rule()
            }
        }
        else if(rule == 2){
            if (computer_choice == your_choice){
                Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show()
                random_rule()
            }
            else if(your_choice == "rock" && computer_choice == "scissors"){
                computerScore++
                tv_score_computer?.text = "Enemy : " + computerScore
                Toast.makeText(this, "You Lose!", Toast.LENGTH_SHORT).show()
                random_rule()
            }
            else if(your_choice == "paper" && computer_choice == "rock"){
                computerScore++
                tv_score_computer?.text = "Enemy : " + computerScore
                Toast.makeText(this, "You Lose!", Toast.LENGTH_SHORT).show()
                random_rule()
            }
            else if(your_choice == "scissors" && computer_choice == "paper"){
                computerScore++
                tv_score_computer?.text = "Enemy : " + computerScore
                Toast.makeText(this, "You Lose!", Toast.LENGTH_SHORT).show()
                random_rule()
            }
            else if(your_choice == "scissors" && computer_choice == "rock"){
                humanScore++
                tv_score_human?.text = "You : " + humanScore
                Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show()
                random_rule()
            }
            else if(your_choice == "rock" && computer_choice == "paper"){

                humanScore++
                tv_score_human?.text = "You : " + humanScore
                Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show()
                random_rule()
            }
            else if(your_choice == "paper" && computer_choice == "scissors"){
                humanScore++
                tv_score_human?.text = "You : " + humanScore
                Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show()
                random_rule()
            }
        }
        else if(rule == 3){
            if (computer_choice == your_choice){
                humanScore++
                computerScore++
                tv_score_human?.text = "You : " + humanScore
                tv_score_computer?.text = "Enemy : " + computerScore
                Toast.makeText(this, "You Both Win", Toast.LENGTH_SHORT).show()
                random_rule()
            }
            else if(your_choice == "rock" && computer_choice == "scissors"){
                humanScore++
                tv_score_human?.text = "You : " + humanScore
                Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show()
                random_rule()
            }
            else if(your_choice == "paper" && computer_choice == "rock"){
                humanScore++
                tv_score_human?.text = "You : " + humanScore
                Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show()
                random_rule()
            }
            else if(your_choice == "scissors" && computer_choice == "paper"){
                humanScore++
                tv_score_human?.text = "You : " + humanScore
                Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show()
                random_rule()
            }
            else if(your_choice == "scissors" && computer_choice == "rock"){
                computerScore++
                tv_score_computer?.text = "Enemy : " + computerScore
                Toast.makeText(this, "You Lose!", Toast.LENGTH_SHORT).show()
                random_rule()
            }
            else if(your_choice == "rock" && computer_choice == "paper"){
                computerScore++
                tv_score_computer?.text = "Enemy : " + computerScore
                Toast.makeText(this, "You Lose!", Toast.LENGTH_SHORT).show()
                random_rule()
            }
            else if(your_choice == "paper" && computer_choice == "scissors"){
                computerScore++
                tv_score_computer?.text = "Enemy : " + computerScore
                Toast.makeText(this, "You Lose!", Toast.LENGTH_SHORT).show()
                random_rule()
            }
        }

        if (humanScore == 10){
            val intent = Intent(this, WinActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
        if (computerScore == 10){
            val intent = Intent(this, LoseActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
