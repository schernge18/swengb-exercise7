package at.fh.swengb.loggingviewsandactivity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class HigherOrderActivityy : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_order_activityy)
        myHigherOrderFunction { x: Int -> x + 606 }
        myHigherOrderFunction (fun(x: Int) = x + 606)
        kotlinHigherOrderWithList()



    }

    private fun myHigherOrderFunction(param: (Int) -> Int) {
        if (param(6) == 612) {
            Log.e("HIGHER_ORDER", "Congrats, your first lambda works :)")
        }
    }

    private fun kotlinHigherOrderWithList() {
        val list = LessonRepository.lessonsList()

        Log.e("Higher_Order","------------")
        val heldByBloder = list.filter { les -> les.lecturers.any{ lec -> lec.name == "Lukas Bloder"}
        }.joinToString { it.name }

        val topicMap = list.map { it.topic to it }.toMap()


        val avgLecture =
                if (list.filter {  it.type == LessonType.LECTURE  }.map { it.ratings.count() }.sum() == 0 )
                    0
                else list.filter { it.type == LessonType.LECTURE }.map { it.ratingAverage() }.sum() / list.filter { it.type == LessonType.LECTURE }.map { it.ratings.count() }.sum()

        Log.e("Bloder", "$heldByBloder")

        Log.e("Map", "$topicMap")

        Log.e("Average", "$avgLecture")

    }

}


