package at.fh.swengb.loggingviewsandactivity

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lesson_rating2.*

class LessonRatingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_rating2)

        val lessonId = intent.getStringExtra(LessonListActivity.EXTRA_LESSON_ID)

        if (lessonId == null) {
            finish()
        } else {
            lesson_rating_header.text = LessonRepository.lessonById(lessonId)?.name

            rate_lesson.setOnClickListener{
                val myRating = lesson_rating_bar.rating.toDouble()
                val myFeedback = lesson_feedback.text.toString()

                val lessonRating = LessonRating(myRating,myFeedback)

                LessonRepository.rateLesson(lessonId, lessonRating)

                setResult(Activity.RESULT_OK)
                finish()
             }
        }
    }
}
