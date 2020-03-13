
// Need to make sure these classes are available in the 
// main DEX file for API 19

-keep class android.support.test.internal** { *; }
-keep class org.junit.** { *; }
-keep public class com.company.application.acceptance.** { *; }
-keep public class com.company.application.integration.** { *; }