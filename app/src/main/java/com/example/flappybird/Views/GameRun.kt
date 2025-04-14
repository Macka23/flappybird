package com.example.flappybird.Views

import android.content.Intent
import android.os.SystemClock
import com.example.flappybird.Activities.GameOverActivity
import com.example.flappybird.GameObjects.AllObjects

class GameRun(val allObjects: AllObjects) {
    private var previousFrameTime: Long = 0

    open fun run(){
        val currentTime = System.currentTimeMillis()
        val elapsedTimeMS: Double = (currentTime - previousFrameTime).toDouble()

        if (elapsedTimeMS > 10){
            for (pipe in allObjects.ListOfPipes) {
                pipe.update()
            }
            previousFrameTime = currentTime
        }

        if (SystemClock.currentThreadTimeMillis() > 200) {
            allObjects.bird.update(elapsedTimeMS.toInt())
        }

        if (allObjects.ListOfPipes.last().x_pos < allObjects.bird.x){
            createPipe()
            allObjects.score.update(elapsedTimeMS.toInt())
        }


        if (allObjects.ListOfPipes.first().x_pos + allObjects.ListOfPipes.first().width < 0){
            allObjects.ListOfPipes.removeAt(0)
        }

        if (returnEndGame()){
            gameOver()
        }
    }

    private fun gameOver(){
        val intent = Intent(allObjects.context, GameOverActivity::class.java)
        intent.putExtra("score", allObjects.score.yourScore)
        allObjects.context.startActivity(intent)
    }

    private fun returnEndGame(): Boolean {
        for (pipe in allObjects.ListOfPipes){
            if (allObjects.bird.returnCollision(pipe)){
                return true
            }
        }
        return false
    }

    private fun createPipe(){
        if (allObjects.score.yourScore < 3){
            allObjects.ListOfPipes.add(PipeFactory.createPipe(PipeType.STATIC))
        }

        else {
            allObjects.ListOfPipes.add(PipeFactory.createPipe(PipeType.MOVING))
        }
    }
}