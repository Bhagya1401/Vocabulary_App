package uk.ac.aber.dcs.assigmenttemplate.ui.theme
import androidx.compose.ui.graphics.Color

val md_theme_light_primary = Color(0xFF805600)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFFFFDDB0)
val md_theme_light_onPrimaryContainer = Color(0xFF281800)
val md_theme_light_secondary = Color(0xFF885200)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_secondaryContainer = Color(0xFFFFDDBB)
val md_theme_light_onSecondaryContainer = Color(0xFF2B1700)
val md_theme_light_tertiary = Color(0xFF954A04)
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_tertiaryContainer = Color(0xFFFFDCC7)
val md_theme_light_onTertiaryContainer = Color(0xFF311300)
val md_theme_light_error = Color(0xFFBA1A1A)
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_onErrorContainer = Color(0xFF410002)
val md_theme_light_background = Color(0xFFFFFBFF)
val md_theme_light_onBackground = Color(0xFF1F1B16)
val md_theme_light_surface = Color(0xFFFFFBFF)
val md_theme_light_onSurface = Color(0xFF1F1B16)
val md_theme_light_surfaceVariant = Color(0xFFEFE0CF)
val md_theme_light_onSurfaceVariant = Color(0xFF4F4539)
val md_theme_light_outline = Color(0xFF817567)
val md_theme_light_inverseOnSurface = Color(0xFFF9EFE7)
val md_theme_light_inverseSurface = Color(0xFF34302A)
val md_theme_light_inversePrimary = Color(0xFFFDBA4B)
val md_theme_light_shadow = Color(0xFF000000)
val md_theme_light_surfaceTint = Color(0xFF805600)
val md_theme_light_outlineVariant = Color(0xFFD2C4B4)
val md_theme_light_scrim = Color(0xFF000000)

val md_theme_dark_primary = Color(0xFFFDBA4B)
val md_theme_dark_onPrimary = Color(0xFF442C00)
val md_theme_dark_primaryContainer = Color(0xFF614000)
val md_theme_dark_onPrimaryContainer = Color(0xFFFFDDB0)
val md_theme_dark_secondary = Color(0xFFFFB868)
val md_theme_dark_onSecondary = Color(0xFF482900)
val md_theme_dark_secondaryContainer = Color(0xFF673D00)
val md_theme_dark_onSecondaryContainer = Color(0xFFFFDDBB)
val md_theme_dark_tertiary = Color(0xFFFFB787)
val md_theme_dark_onTertiary = Color(0xFF502400)
val md_theme_dark_tertiaryContainer = Color(0xFF723600)
val md_theme_dark_onTertiaryContainer = Color(0xFFFFDCC7)
val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)
val md_theme_dark_background = Color(0xFF1F1B16)
val md_theme_dark_onBackground = Color(0xFFEAE1D9)
val md_theme_dark_surface = Color(0xFF1F1B16)
val md_theme_dark_onSurface = Color(0xFFEAE1D9)
val md_theme_dark_surfaceVariant = Color(0xFF4F4539)
val md_theme_dark_onSurfaceVariant = Color(0xFFD2C4B4)
val md_theme_dark_outline = Color(0xFF9B8F80)
val md_theme_dark_inverseOnSurface = Color(0xFF1F1B16)
val md_theme_dark_inverseSurface = Color(0xFFEAE1D9)
val md_theme_dark_inversePrimary = Color(0xFF805600)
val md_theme_dark_shadow = Color(0xFF000000)
val md_theme_dark_surfaceTint = Color(0xFFFDBA4B)
val md_theme_dark_outlineVariant = Color(0xFF4F4539)
val md_theme_dark_scrim = Color(0xFF000000)


val seed = Color(0xFFEDDECD)
val RightAnswer = Color(0xFFCCFF99)
val WrongAnswer = Color(0xFFFF9966)
val light_RightAnswer = Color(0xFF406915)
val light_onRightAnswer = Color(0xFFFFFFFF)
val light_RightAnswerContainer = Color(0xFFBFF28D)
val light_onRightAnswerContainer = Color(0xFF0E2000)
val dark_RightAnswer = Color(0xFFA4D574)
val dark_onRightAnswer = Color(0xFF1C3700)
val dark_RightAnswerContainer = Color(0xFF2B5000)
val dark_onRightAnswerContainer = Color(0xFFBFF28D)
val light_WrongAnswer = Color(0xFF984718)
val light_onWrongAnswer = Color(0xFFFFFFFF)
val light_WrongAnswerContainer = Color(0xFFFFDBCC)
val light_onWrongAnswerContainer = Color(0xFF351000)
val dark_WrongAnswer = Color(0xFFFFB693)
val dark_onWrongAnswer = Color(0xFF561F00)
val dark_WrongAnswerContainer = Color(0xFF7A3001)
val dark_onWrongAnswerContainer = Color(0xFFFFDBCC)

/*
@Composable
fun AssigmentTemplateTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
 */