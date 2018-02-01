import org.gradle.kotlin.dsl.task
import java.sql.DriverManager.println

task("hello",{
    println("hello im gradle helloworld")
})