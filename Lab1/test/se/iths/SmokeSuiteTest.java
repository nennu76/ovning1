package se.iths;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@IncludeCategory(SmokeCategory.class) //finns �ven ExcludeCategory, t.ex. in progress som inte vi vill k�ra
@SuiteClasses(Lab1Test.class)

public class SmokeSuiteTest {

}
