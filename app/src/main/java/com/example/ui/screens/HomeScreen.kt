package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.data.BlogArticle
import com.example.data.FindCategory
import com.example.data.HerFindsConstants
import com.example.data.ShoppingGuide
import com.example.ui.HerFindsUiState
import com.example.ui.components.AmazonWishlistBannerCard
import com.example.ui.components.CategoryVisualTile
import com.example.ui.components.ChloeBennettPortrait
import com.example.ui.components.EditorialFooter
import com.example.ui.components.NewsletterSignupSection
import com.example.ui.components.ProductFindCard
import com.example.ui.components.copyTextToClipboard
import com.example.ui.components.openExternalUrl
import com.example.ui.theme.BlushSurface
import com.example.ui.theme.BlushTint
import com.example.ui.theme.BerryRose

@Composable
fun HomeScreen(
    uiState: HerFindsUiState,
    onExploreFinds: () -> Unit,
    onReadGuides: () -> Unit,
    onCategoryClick: (FindCategory) -> Unit,
    onFindClick: (String) -> Unit,
    onToggleSave: (String) -> Unit,
    onGuideClick: (String) -> Unit,
    onArticleClick: (String) -> Unit,
    onOpenAboutLegal: (String) -> Unit,
    onSubscribeNewsletter: (String) -> Unit,
    onUnsubscribeNewsletter: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        // 1. Hero Section (Blush Rose Editorial Canvas)
        item {
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(BlushTint, BlushSurface)
                        )
                    )
                    .padding(horizontal = 20.dp, vertical = 24.dp)
            ) {
                val isWide = maxWidth >= 680.dp
                if (isWide) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .widthIn(max = 1040.dp)
                            .align(Alignment.Center),
                        horizontalArrangement = Arrangement.spacedBy(28.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        HeroCopyBlock(
                            onExploreFinds = onExploreFinds,
                            onReadGuides = onReadGuides,
                            onDisclosureClick = { onOpenAboutLegal("disclosure") },
                            modifier = Modifier.weight(1.1f)
                        )
                        ChloeBennettPortrait(
                            modifier = Modifier
                                .weight(0.9f)
                                .height(300.dp)
                        )
                    }
                } else {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        HeroCopyBlock(
                            onExploreFinds = onExploreFinds,
                            onReadGuides = onReadGuides,
                            onDisclosureClick = { onOpenAboutLegal("disclosure") }
                        )
                        ChloeBennettPortrait(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp)
                        )
                    }
                }
            }
        }

        // 2. Linked Amazon Wishlist Invite Banner
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 18.dp),
                contentAlignment = Alignment.Center
            ) {
                AmazonWishlistBannerCard(
                    onOpenWishlist = {
                        openExternalUrl(context, HerFindsConstants.CURATED_AMAZON_WISHLIST_URL)
                    },
                    onCopyLink = {
                        copyTextToClipboard(
                            context,
                            "HerFinds Amazon Wishlist",
                            HerFindsConstants.CURATED_AMAZON_WISHLIST_URL
                        )
                    },
                    modifier = Modifier.widthIn(max = 880.dp)
                )
            }
        }

        // 3. Featured Categories
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                SectionEyebrowHeader(
                    eyebrow = "BROWSE",
                    title = "Featured Categories"
                )
                Spacer(modifier = Modifier.height(14.dp))
                BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
                    val columns = if (maxWidth >= 660.dp) 3 else 2
                    val rows = FindCategory.entries.chunked(columns)
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        rows.forEach { rowCategories ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                rowCategories.forEach { category ->
                                    CategoryTileCard(
                                        category = category,
                                        onClick = { onCategoryClick(category) },
                                        modifier = Modifier.weight(1f)
                                    )
                                }
                                if (rowCategories.size < columns) {
                                    repeat(columns - rowCategories.size) {
                                        Spacer(modifier = Modifier.weight(1f))
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // 4. Handpicked Trending Finds
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, bottom = 12.dp)
            ) {
                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    SectionEyebrowHeader(
                        eyebrow = "HANDPICKED",
                        title = "Trending Finds",
                        subtitle = HerFindsConstants.AFFILIATE_DISCLOSURE_SHORT
                    )
                }
                Spacer(modifier = Modifier.height(14.dp))
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    items(uiState.trendingFinds, key = { it.id }) { find ->
                        ProductFindCard(
                            find = find,
                            isSaved = find.id in uiState.savedFindIds,
                            onToggleSave = { onToggleSave(find.id) },
                            onCardClick = { onFindClick(find.id) },
                            onViewOnAmazon = { openExternalUrl(context, find.amazonUrl) },
                            modifier = Modifier.width(276.dp)
                        )
                    }
                }
            }
        }

        // 5. Meet Chloe, Your HerFinds Guide
        item {
            Surface(
                color = MaterialTheme.colorScheme.surface,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.6f)),
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 18.dp)
            ) {
                BoxWithConstraints(modifier = Modifier.padding(18.dp)) {
                    val isWide = maxWidth >= 560.dp
                    if (isWide) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(20.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ChloeBennettPortrait(
                                showBadge = false,
                                modifier = Modifier
                                    .width(220.dp)
                                    .height(210.dp)
                            )
                            ChloeGuideCopy(
                                onExploreClick = onExploreFinds,
                                onAboutClick = { onOpenAboutLegal("about") },
                                modifier = Modifier.weight(1f)
                            )
                        }
                    } else {
                        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                            ChloeBennettPortrait(
                                showBadge = false,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                            )
                            ChloeGuideCopy(
                                onExploreClick = onExploreFinds,
                                onAboutClick = { onOpenAboutLegal("about") }
                            )
                        }
                    }
                }
            }
        }

        // 6. Featured Shopping Guides (Soft Blush Band)
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(BlushSurface)
                    .padding(vertical = 26.dp)
            ) {
                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    SectionEyebrowHeader(
                        eyebrow = "EDITORIAL",
                        title = "Featured Shopping Guides"
                    )
                }
                Spacer(modifier = Modifier.height(14.dp))
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(uiState.guides, key = { it.id }) { guide ->
                        ShoppingGuideTileCard(
                            guide = guide,
                            onClick = { onGuideClick(guide.id) },
                            modifier = Modifier.width(236.dp)
                        )
                    }
                }
            }
        }

        // 7. Latest Articles
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 24.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                SectionEyebrowHeader(
                    eyebrow = "FROM THE BLOG",
                    title = "Latest Articles"
                )
                Spacer(modifier = Modifier.height(4.dp))
                uiState.articles.forEach { article ->
                    BlogArticlePreviewCard(
                        article = article,
                        onClick = { onArticleClick(article.id) }
                    )
                }
            }
        }

        // 8. Newsletter Signup Section
        item {
            NewsletterSignupSection(
                subscribedEmail = uiState.subscribedEmail,
                onSubscribe = onSubscribeNewsletter,
                onUnsubscribe = onUnsubscribeNewsletter,
                onPrivacyClick = { onOpenAboutLegal("privacy") }
            )
        }

        // 9. Editorial Footer
        item {
            EditorialFooter(
                onShopAllClick = onExploreFinds,
                onGuidesClick = onReadGuides,
                onCategoryClick = onCategoryClick,
                onLegalClick = onOpenAboutLegal
            )
        }
    }
}

@Composable
private fun HeroCopyBlock(
    onExploreFinds: () -> Unit,
    onReadGuides: () -> Unit,
    onDisclosureClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = "DISCOVER • SHOP • LIVE BETTER",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.secondary
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Discover Finds You'll Love",
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Explore stylish essentials, clever home finds, beauty favorites, and everyday products worth discovering.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(18.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = onExploreFinds,
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                modifier = Modifier
                    .minimumInteractiveComponentSize()
                    .testTag("hero_explore_finds_button")
            ) {
                Text("Explore Finds")
            }
            OutlinedButton(
                onClick = onReadGuides,
                shape = RoundedCornerShape(50),
                border = BorderStroke(1.5.dp, MaterialTheme.colorScheme.primary),
                modifier = Modifier
                    .minimumInteractiveComponentSize()
                    .testTag("hero_read_guides_button")
            ) {
                Text("Read Our Guides", color = MaterialTheme.colorScheme.primary)
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Some links are affiliate links. ",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = "Affiliate disclosure",
                style = MaterialTheme.typography.bodySmall.copy(textDecoration = TextDecoration.Underline),
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier
                    .clickable(onClick = onDisclosureClick)
                    .padding(vertical = 4.dp)
                    .testTag("hero_affiliate_disclosure_link")
            )
        }
    }
}

@Composable
private fun ChloeGuideCopy(
    onExploreClick: () -> Unit,
    onAboutClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = "YOUR GUIDE",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.secondary
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "Meet Chloe, Your HerFinds Guide",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Chloe is our fictional AI brand ambassador who helps introduce useful finds, shopping inspiration, and lifestyle ideas.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Chloe Bennett is an AI-generated character. She has not personally tested any product.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.85f)
        )
        Spacer(modifier = Modifier.height(14.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = onExploreClick,
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .minimumInteractiveComponentSize()
                    .testTag("chloe_explore_button")
            ) {
                Text("Explore HerFinds")
            }
            OutlinedButton(
                onClick = onAboutClick,
                shape = RoundedCornerShape(50),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
                modifier = Modifier.minimumInteractiveComponentSize()
            ) {
                Text("About Chloe")
            }
        }
    }
}

@Composable
fun SectionEyebrowHeader(
    eyebrow: String,
    title: String,
    subtitle: String? = null,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = eyebrow,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.secondary
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        if (!subtitle.isNullOrBlank()) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun CategoryTileCard(
    category: FindCategory,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.6f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = modifier
            .clip(RoundedCornerShape(18.dp))
            .clickable(onClick = onClick)
            .testTag("category_tile_${category.name.lowercase()}")
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            CategoryVisualTile(
                category = category,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(92.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = category.title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Explore curated picks",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun ShoppingGuideTileCard(
    guide: ShoppingGuide,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.6f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .clickable(onClick = onClick)
            .testTag("guide_card_${guide.id}")
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            CategoryVisualTile(
                category = guide.category,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(118.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "${guide.readTimeMinutes} MIN GUIDE",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = guide.title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = guide.subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun BlogArticlePreviewCard(
    article: BlogArticle,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.65f)),
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .clickable(onClick = onClick)
            .testTag("article_card_${article.id}")
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = article.categoryLabel,
                    style = MaterialTheme.typography.labelMedium,
                    color = BerryRose
                )
                Text(
                    text = "${article.readTimeMinutes} min read",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = article.title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = article.excerpt,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Read More",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.secondary
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.ArrowForward,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}
