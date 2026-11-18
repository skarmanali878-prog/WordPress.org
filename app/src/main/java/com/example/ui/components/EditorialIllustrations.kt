package com.example.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.FindCategory
import com.example.data.ProductVisualType
import com.example.ui.theme.BerryRose
import com.example.ui.theme.BerryRoseSoft
import com.example.ui.theme.BlushCardTile
import com.example.ui.theme.BlushSurface
import com.example.ui.theme.BlushTint
import com.example.ui.theme.EspressoInk
import com.example.ui.theme.ForestGreen
import com.example.ui.theme.ForestGreenTint
import com.example.ui.theme.IvoryCream
import com.example.ui.theme.MutedPlum
import com.example.ui.theme.PlusJakartaSansFamily

/**
 * Editorial vector illustration of Chloe Bennett (long dark brown hair, pink and neutral outfit)
 * with explicit AI-generated fictional ambassador badge as specified in the HerFinds design.
 */
@Composable
fun ChloeBennettPortrait(
    modifier: Modifier = Modifier,
    showBadge: Boolean = true
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(22.dp))
            .background(
                Brush.linearGradient(
                    colors = listOf(BlushCardTile, BlushTint, Color(0xFFF4D5E2))
                )
            )
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val w = size.width
            val h = size.height

            // Soft editorial arch behind Chloe
            drawRoundRect(
                color = IvoryCream.copy(alpha = 0.65f),
                topLeft = Offset(w * 0.16f, h * 0.08f),
                size = Size(w * 0.68f, h * 0.92f),
                cornerRadius = CornerRadius(w * 0.34f, w * 0.34f)
            )

            // Subtle botanical leaf accent top-right
            val leafPath = Path().apply {
                moveTo(w * 0.78f, h * 0.28f)
                quadraticTo(w * 0.88f, h * 0.16f, w * 0.92f, h * 0.25f)
                quadraticTo(w * 0.86f, h * 0.34f, w * 0.78f, h * 0.28f)
            }
            drawPath(leafPath, color = ForestGreen.copy(alpha = 0.24f))

            val hairDark = Color(0xFF3A231E)
            val hairHighlight = Color(0xFF54342D)
            val skinTone = Color(0xFFF0C6AE)
            val skinShadow = Color(0xFFE0B097)
            val pinkBlazer = Color(0xFFD65689)
            val neutralTop = Color(0xFFFAF3EC)

            // Long dark brown hair (back layer flowing past shoulders)
            val hairBack = Path().apply {
                moveTo(w * 0.33f, h * 0.34f)
                quadraticTo(w * 0.30f, h * 0.56f, w * 0.28f, h * 0.76f)
                lineTo(w * 0.72f, h * 0.76f)
                quadraticTo(w * 0.70f, h * 0.56f, w * 0.67f, h * 0.34f)
                quadraticTo(w * 0.50f, h * 0.14f, w * 0.33f, h * 0.34f)
                close()
            }
            drawPath(hairBack, color = hairDark)

            // Neutral ivory knit top
            val torsoNeutral = Path().apply {
                moveTo(w * 0.34f, h * 0.68f)
                quadraticTo(w * 0.50f, h * 0.62f, w * 0.66f, h * 0.68f)
                lineTo(w * 0.73f, h * 1.0f)
                lineTo(w * 0.27f, h * 1.0f)
                close()
            }
            drawPath(torsoNeutral, color = neutralTop)

            // Pink blazer lapels (left and right)
            val leftBlazer = Path().apply {
                moveTo(w * 0.26f, h * 0.72f)
                quadraticTo(w * 0.36f, h * 0.66f, w * 0.43f, h * 0.72f)
                lineTo(w * 0.46f, h * 1.0f)
                lineTo(w * 0.20f, h * 1.0f)
                close()
            }
            drawPath(leftBlazer, color = pinkBlazer)

            val rightBlazer = Path().apply {
                moveTo(w * 0.74f, h * 0.72f)
                quadraticTo(w * 0.64f, h * 0.66f, w * 0.57f, h * 0.72f)
                lineTo(w * 0.54f, h * 1.0f)
                lineTo(w * 0.80f, h * 1.0f)
                close()
            }
            drawPath(rightBlazer, color = pinkBlazer)

            // Neck
            drawRoundRect(
                color = skinShadow,
                topLeft = Offset(w * 0.455f, h * 0.53f),
                size = Size(w * 0.09f, h * 0.14f),
                cornerRadius = CornerRadius(12f, 12f)
            )

            // Delicate gold pendant necklace
            drawArc(
                color = Color(0xFFD6A85E),
                startAngle = 20f,
                sweepAngle = 140f,
                useCenter = false,
                topLeft = Offset(w * 0.42f, h * 0.60f),
                size = Size(w * 0.16f, h * 0.10f),
                style = Stroke(width = 2.5f)
            )
            drawCircle(
                color = Color(0xFFD6A85E),
                radius = w * 0.012f,
                center = Offset(w * 0.50f, h * 0.705f)
            )

            // Face oval
            drawOval(
                color = skinTone,
                topLeft = Offset(w * 0.38f, h * 0.27f),
                size = Size(w * 0.24f, h * 0.30f)
            )

            // Soft blush on cheeks
            drawCircle(
                color = BerryRoseSoft.copy(alpha = 0.22f),
                radius = w * 0.032f,
                center = Offset(w * 0.43f, h * 0.455f)
            )
            drawCircle(
                color = BerryRoseSoft.copy(alpha = 0.22f),
                radius = w * 0.032f,
                center = Offset(w * 0.57f, h * 0.455f)
            )

            // Hair crown & framing waves
            val hairCrown = Path().apply {
                moveTo(w * 0.36f, h * 0.39f)
                quadraticTo(w * 0.37f, h * 0.22f, w * 0.51f, h * 0.22f)
                quadraticTo(w * 0.64f, h * 0.22f, w * 0.64f, h * 0.40f)
                quadraticTo(w * 0.61f, h * 0.31f, w * 0.52f, h * 0.30f)
                quadraticTo(w * 0.41f, h * 0.30f, w * 0.36f, h * 0.39f)
                close()
            }
            drawPath(hairCrown, color = hairHighlight)

            // Minimal editorial facial features (brows, eyes, warm smile)
            drawLine(
                color = hairDark,
                start = Offset(w * 0.425f, h * 0.38f),
                end = Offset(w * 0.465f, h * 0.375f),
                strokeWidth = 3f,
                cap = StrokeCap.Round
            )
            drawLine(
                color = hairDark,
                start = Offset(w * 0.535f, h * 0.375f),
                end = Offset(w * 0.575f, h * 0.38f),
                strokeWidth = 3f,
                cap = StrokeCap.Round
            )
            drawCircle(color = hairDark, radius = w * 0.011f, center = Offset(w * 0.445f, h * 0.41f))
            drawCircle(color = hairDark, radius = w * 0.011f, center = Offset(w * 0.555f, h * 0.41f))

            // Warm berry smile
            drawArc(
                color = BerryRose.copy(alpha = 0.85f),
                startAngle = 15f,
                sweepAngle = 150f,
                useCenter = false,
                topLeft = Offset(w * 0.46f, h * 0.465f),
                size = Size(w * 0.08f, h * 0.045f),
                style = Stroke(width = 3.2f, cap = StrokeCap.Round)
            )
        }

        if (showBadge) {
            Surface(
                color = Color.White.copy(alpha = 0.92f),
                shape = RoundedCornerShape(50),
                shadowElevation = 2.dp,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(12.dp)
            ) {
                Text(
                    text = "AI-generated fictional ambassador",
                    fontFamily = PlusJakartaSansFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 11.sp,
                    color = MutedPlum,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                )
            }
        }
    }
}

@Composable
fun CategoryVisualTile(
    category: FindCategory,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(
                Brush.verticalGradient(
                    colors = listOf(BlushCardTile, BlushTint)
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        val visualType = when (category) {
            FindCategory.FASHION -> ProductVisualType.TOTE_BAG
            FindCategory.BEAUTY -> ProductVisualType.GLOW_SERUM
            FindCategory.HOME -> ProductVisualType.CERAMIC_VASE
            FindCategory.KITCHEN -> ProductVisualType.ELECTRIC_KETTLE
            FindCategory.ORGANIZATION -> ProductVisualType.PANTRY_JARS
            FindCategory.LIFESTYLE -> ProductVisualType.LINEN_JOURNAL
        }
        ProductGraphicCanvas(
            visualType = visualType,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun ProductVisualTile(
    visualType: ProductVisualType,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(
                Brush.radialGradient(
                    colors = listOf(BlushSurface, BlushCardTile)
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        ProductGraphicCanvas(
            visualType = visualType,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
private fun ProductGraphicCanvas(
    visualType: ProductVisualType,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val cx = w * 0.5f
        val cy = h * 0.5f

        // Soft circular stage backdrop
        drawCircle(
            color = IvoryCream.copy(alpha = 0.72f),
            radius = minOf(w, h) * 0.34f,
            center = Offset(cx, cy)
        )

        val ink = EspressoInk
        val rose = BerryRose
        val softRose = BerryRoseSoft
        val green = ForestGreen
        val sand = Color(0xFFD9C3B0)
        val gold = Color(0xFFD1A45B)

        when (visualType) {
            ProductVisualType.TOTE_BAG -> {
                // Handle
                drawArc(
                    color = ink,
                    startAngle = 180f,
                    sweepAngle = 180f,
                    useCenter = false,
                    topLeft = Offset(cx - w * 0.11f, cy - h * 0.28f),
                    size = Size(w * 0.22f, h * 0.22f),
                    style = Stroke(width = 6f, cap = StrokeCap.Round)
                )
                // Body
                drawRoundRect(
                    color = Color(0xFFC9A68B),
                    topLeft = Offset(cx - w * 0.19f, cy - h * 0.12f),
                    size = Size(w * 0.38f, h * 0.36f),
                    cornerRadius = CornerRadius(14f, 14f)
                )
                drawLine(
                    color = gold,
                    start = Offset(cx - w * 0.18f, cy - h * 0.02f),
                    end = Offset(cx + w * 0.18f, cy - h * 0.02f),
                    strokeWidth = 4f
                )
            }
            ProductVisualType.CARDIGAN -> {
                val sweater = Path().apply {
                    moveTo(cx - w * 0.15f, cy - h * 0.22f)
                    lineTo(cx + w * 0.15f, cy - h * 0.22f)
                    lineTo(cx + w * 0.26f, cy + h * 0.18f)
                    lineTo(cx + w * 0.15f, cy + h * 0.22f)
                    lineTo(cx + w * 0.12f, cy + h * 0.02f)
                    lineTo(cx + w * 0.12f, cy + h * 0.25f)
                    lineTo(cx - w * 0.12f, cy + h * 0.25f)
                    lineTo(cx - w * 0.12f, cy + h * 0.02f)
                    lineTo(cx - w * 0.15f, cy + h * 0.22f)
                    lineTo(cx - w * 0.26f, cy + h * 0.18f)
                    close()
                }
                drawPath(sweater, color = Color(0xFFE7CFC7))
                drawLine(
                    color = MutedPlum,
                    start = Offset(cx, cy - h * 0.18f),
                    end = Offset(cx, cy + h * 0.25f),
                    strokeWidth = 3f
                )
                listOf(-0.08f, 0.02f, 0.12f).forEach { dy ->
                    drawCircle(color = ink, radius = 4f, center = Offset(cx, cy + h * dy))
                }
            }
            ProductVisualType.SILK_SCARF -> {
                val scarf = Path().apply {
                    moveTo(cx - w * 0.18f, cy - h * 0.16f)
                    quadraticTo(cx, cy - h * 0.24f, cx + w * 0.18f, cy - h * 0.12f)
                    lineTo(cx + w * 0.14f, cy + h * 0.22f)
                    quadraticTo(cx, cy + h * 0.12f, cx - w * 0.16f, cy + h * 0.24f)
                    close()
                }
                drawPath(scarf, color = softRose.copy(alpha = 0.85f))
                drawCircle(color = IvoryCream, radius = 10f, center = Offset(cx - w * 0.04f, cy - h * 0.02f))
                drawCircle(color = rose, radius = 7f, center = Offset(cx + w * 0.06f, cy + h * 0.08f))
            }
            ProductVisualType.SUNGLASSES -> {
                drawOval(
                    color = ink,
                    topLeft = Offset(cx - w * 0.25f, cy - h * 0.08f),
                    size = Size(w * 0.21f, h * 0.16f)
                )
                drawOval(
                    color = ink,
                    topLeft = Offset(cx + w * 0.04f, cy - h * 0.08f),
                    size = Size(w * 0.21f, h * 0.16f)
                )
                drawLine(
                    color = gold,
                    start = Offset(cx - w * 0.04f, cy - h * 0.02f),
                    end = Offset(cx + w * 0.04f, cy - h * 0.02f),
                    strokeWidth = 5f
                )
            }
            ProductVisualType.GLOW_SERUM -> {
                // Dropper cap
                drawRoundRect(
                    color = ink,
                    topLeft = Offset(cx - w * 0.05f, cy - h * 0.27f),
                    size = Size(w * 0.10f, h * 0.11f),
                    cornerRadius = CornerRadius(12f, 12f)
                )
                drawRect(
                    color = gold,
                    topLeft = Offset(cx - w * 0.07f, cy - h * 0.17f),
                    size = Size(w * 0.14f, h * 0.05f)
                )
                // Bottle
                drawRoundRect(
                    color = softRose.copy(alpha = 0.78f),
                    topLeft = Offset(cx - w * 0.13f, cy - h * 0.11f),
                    size = Size(w * 0.26f, h * 0.36f),
                    cornerRadius = CornerRadius(18f, 18f)
                )
                drawRoundRect(
                    color = IvoryCream,
                    topLeft = Offset(cx - w * 0.09f, cy - h * 0.01f),
                    size = Size(w * 0.18f, h * 0.17f),
                    cornerRadius = CornerRadius(6f, 6f)
                )
            }
            ProductVisualType.CLAW_CLIPS -> {
                drawArc(
                    color = rose.copy(alpha = 0.8f),
                    startAngle = 190f,
                    sweepAngle = 160f,
                    useCenter = false,
                    topLeft = Offset(cx - w * 0.19f, cy - h * 0.15f),
                    size = Size(w * 0.38f, h * 0.26f),
                    style = Stroke(width = 12f, cap = StrokeCap.Round)
                )
                drawRoundRect(
                    color = sand,
                    topLeft = Offset(cx - w * 0.15f, cy + h * 0.03f),
                    size = Size(w * 0.30f, h * 0.11f),
                    cornerRadius = CornerRadius(16f, 16f)
                )
            }
            ProductVisualType.BRUSH_SET -> {
                listOf(-0.11f, 0f, 0.11f).forEachIndexed { idx, dx ->
                    val x = cx + w * dx
                    drawLine(
                        color = if (idx == 1) rose else softRose,
                        start = Offset(x, cy + h * 0.24f),
                        end = Offset(x, cy - h * 0.05f),
                        strokeWidth = 9f,
                        cap = StrokeCap.Round
                    )
                    drawOval(
                        color = ink,
                        topLeft = Offset(x - 10f, cy - h * 0.22f),
                        size = Size(20f, h * 0.16f)
                    )
                }
            }
            ProductVisualType.AMBER_LAMP -> {
                drawOval(
                    color = Color(0xFFF3C87A),
                    topLeft = Offset(cx - w * 0.19f, cy - h * 0.24f),
                    size = Size(w * 0.38f, h * 0.26f)
                )
                drawRect(
                    color = gold,
                    topLeft = Offset(cx - w * 0.03f, cy + h * 0.02f),
                    size = Size(w * 0.06f, h * 0.17f)
                )
                drawRoundRect(
                    color = gold,
                    topLeft = Offset(cx - w * 0.13f, cy + h * 0.18f),
                    size = Size(w * 0.26f, h * 0.07f),
                    cornerRadius = CornerRadius(10f, 10f)
                )
            }
            ProductVisualType.THROW_BLANKET -> {
                drawRoundRect(
                    color = Color(0xFFEDE2D5),
                    topLeft = Offset(cx - w * 0.21f, cy - h * 0.17f),
                    size = Size(w * 0.42f, h * 0.32f),
                    cornerRadius = CornerRadius(16f, 16f)
                )
                drawRoundRect(
                    color = softRose.copy(alpha = 0.55f),
                    topLeft = Offset(cx - w * 0.21f, cy - h * 0.02f),
                    size = Size(w * 0.42f, h * 0.10f),
                    cornerRadius = CornerRadius(4f, 4f)
                )
            }
            ProductVisualType.CERAMIC_VASE -> {
                // Botanical stem
                drawLine(
                    color = green,
                    start = Offset(cx, cy - h * 0.06f),
                    end = Offset(cx + w * 0.08f, cy - h * 0.28f),
                    strokeWidth = 4f,
                    cap = StrokeCap.Round
                )
                drawCircle(color = green.copy(alpha = 0.8f), radius = 8f, center = Offset(cx + w * 0.08f, cy - h * 0.26f))
                drawCircle(color = green.copy(alpha = 0.8f), radius = 7f, center = Offset(cx + w * 0.02f, cy - h * 0.20f))
                // Vase body
                drawOval(
                    color = Color(0xFFE7DCD2),
                    topLeft = Offset(cx - w * 0.14f, cy - h * 0.06f),
                    size = Size(w * 0.28f, h * 0.30f)
                )
                drawRoundRect(
                    color = Color(0xFFE7DCD2),
                    topLeft = Offset(cx - w * 0.07f, cy - h * 0.12f),
                    size = Size(w * 0.14f, h * 0.10f),
                    cornerRadius = CornerRadius(6f, 6f)
                )
            }
            ProductVisualType.ELECTRIC_KETTLE -> {
                // Spout
                drawLine(
                    color = ink,
                    start = Offset(cx - w * 0.13f, cy + h * 0.08f),
                    end = Offset(cx - w * 0.26f, cy - h * 0.14f),
                    strokeWidth = 6f,
                    cap = StrokeCap.Round
                )
                // Handle
                drawArc(
                    color = ink,
                    startAngle = -70f,
                    sweepAngle = 150f,
                    useCenter = false,
                    topLeft = Offset(cx + w * 0.08f, cy - h * 0.12f),
                    size = Size(w * 0.16f, h * 0.24f),
                    style = Stroke(width = 6f, cap = StrokeCap.Round)
                )
                // Kettle Body
                drawRoundRect(
                    color = IvoryCream,
                    topLeft = Offset(cx - w * 0.15f, cy - h * 0.14f),
                    size = Size(w * 0.28f, h * 0.35f),
                    cornerRadius = CornerRadius(14f, 14f)
                )
                drawRoundRect(
                    color = ink,
                    topLeft = Offset(cx - w * 0.17f, cy + h * 0.20f),
                    size = Size(w * 0.32f, h * 0.05f),
                    cornerRadius = CornerRadius(6f, 6f)
                )
            }
            ProductVisualType.GLASS_MUGS -> {
                // Straw
                drawLine(
                    color = green,
                    start = Offset(cx + w * 0.03f, cy - h * 0.08f),
                    end = Offset(cx + w * 0.10f, cy - h * 0.28f),
                    strokeWidth = 5f,
                    cap = StrokeCap.Round
                )
                // Glass
                drawRoundRect(
                    color = Color(0xFFD5E6DC),
                    topLeft = Offset(cx - w * 0.12f, cy - h * 0.12f),
                    size = Size(w * 0.24f, h * 0.34f),
                    cornerRadius = CornerRadius(10f, 10f)
                )
                // Bamboo lid
                drawRoundRect(
                    color = sand,
                    topLeft = Offset(cx - w * 0.13f, cy - h * 0.15f),
                    size = Size(w * 0.26f, h * 0.06f),
                    cornerRadius = CornerRadius(6f, 6f)
                )
            }
            ProductVisualType.PANTRY_JARS -> {
                drawRoundRect(
                    color = Color(0xFFE7EFF2),
                    topLeft = Offset(cx - w * 0.17f, cy - h * 0.12f),
                    size = Size(w * 0.18f, h * 0.34f),
                    cornerRadius = CornerRadius(10f, 10f)
                )
                drawRoundRect(
                    color = sand,
                    topLeft = Offset(cx - w * 0.16f, cy - h * 0.16f),
                    size = Size(w * 0.16f, h * 0.06f),
                    cornerRadius = CornerRadius(6f, 6f)
                )
                drawRoundRect(
                    color = Color(0xFFE7EFF2),
                    topLeft = Offset(cx + w * 0.04f, cy - h * 0.04f),
                    size = Size(w * 0.15f, h * 0.26f),
                    cornerRadius = CornerRadius(10f, 10f)
                )
                drawRoundRect(
                    color = sand,
                    topLeft = Offset(cx + w * 0.05f, cy - h * 0.08f),
                    size = Size(w * 0.13f, h * 0.06f),
                    cornerRadius = CornerRadius(6f, 6f)
                )
            }
            ProductVisualType.DRAWER_ORGANIZER -> {
                drawRoundRect(
                    color = Color.White,
                    topLeft = Offset(cx - w * 0.22f, cy - h * 0.16f),
                    size = Size(w * 0.44f, h * 0.32f),
                    cornerRadius = CornerRadius(10f, 10f),
                    style = Stroke(width = 4f)
                )
                drawLine(
                    color = softRose,
                    start = Offset(cx, cy - h * 0.16f),
                    end = Offset(cx, cy + h * 0.16f),
                    strokeWidth = 3.5f
                )
                drawLine(
                    color = softRose,
                    start = Offset(cx - w * 0.22f, cy),
                    end = Offset(cx, cy),
                    strokeWidth = 3.5f
                )
            }
            ProductVisualType.TRAVEL_POUCH -> {
                drawRoundRect(
                    color = softRose,
                    topLeft = Offset(cx - w * 0.22f, cy - h * 0.14f),
                    size = Size(w * 0.44f, h * 0.28f),
                    cornerRadius = CornerRadius(18f, 18f)
                )
                drawLine(
                    color = gold,
                    start = Offset(cx - w * 0.18f, cy - h * 0.05f),
                    end = Offset(cx + w * 0.18f, cy - h * 0.05f),
                    strokeWidth = 4f
                )
            }
            ProductVisualType.TUMBLER -> {
                drawLine(
                    color = IvoryCream,
                    start = Offset(cx, cy - h * 0.18f),
                    end = Offset(cx, cy - h * 0.30f),
                    strokeWidth = 5f,
                    cap = StrokeCap.Round
                )
                drawRoundRect(
                    color = softRose,
                    topLeft = Offset(cx - w * 0.10f, cy - h * 0.16f),
                    size = Size(w * 0.20f, h * 0.38f),
                    cornerRadius = CornerRadius(12f, 12f)
                )
                drawArc(
                    color = rose,
                    startAngle = -90f,
                    sweepAngle = 180f,
                    useCenter = false,
                    topLeft = Offset(cx + w * 0.06f, cy - h * 0.08f),
                    size = Size(w * 0.12f, h * 0.18f),
                    style = Stroke(width = 5f, cap = StrokeCap.Round)
                )
            }
            ProductVisualType.LINEN_JOURNAL -> {
                drawRoundRect(
                    color = Color(0xFFDCC9B8),
                    topLeft = Offset(cx - w * 0.16f, cy - h * 0.22f),
                    size = Size(w * 0.32f, h * 0.44f),
                    cornerRadius = CornerRadius(10f, 10f)
                )
                drawLine(
                    color = rose,
                    start = Offset(cx - w * 0.09f, cy - h * 0.22f),
                    end = Offset(cx - w * 0.09f, cy + h * 0.22f),
                    strokeWidth = 4f
                )
                drawRoundRect(
                    color = IvoryCream,
                    topLeft = Offset(cx - w * 0.02f, cy - h * 0.10f),
                    size = Size(w * 0.12f, h * 0.08f),
                    cornerRadius = CornerRadius(4f, 4f)
                )
            }
            ProductVisualType.DESK_STAND -> {
                drawLine(
                    color = ink,
                    start = Offset(cx - w * 0.18f, cy + h * 0.16f),
                    end = Offset(cx + w * 0.18f, cy + h * 0.16f),
                    strokeWidth = 6f,
                    cap = StrokeCap.Round
                )
                drawLine(
                    color = MutedPlum,
                    start = Offset(cx - w * 0.14f, cy + h * 0.16f),
                    end = Offset(cx + w * 0.16f, cy - h * 0.14f),
                    strokeWidth = 7f,
                    cap = StrokeCap.Round
                )
            }
        }
    }
}
