package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.outlined.AutoStories
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.data.HerFindsConstants
import com.example.ui.HerFindsViewModel
import com.example.ui.components.AnnouncementStrip
import com.example.ui.components.HerFindsTopHeader
import com.example.ui.components.openExternalUrl
import com.example.ui.screens.AboutLegalScreen
import com.example.ui.screens.ArticleDetailScreen
import com.example.ui.screens.FindDetailScreen
import com.example.ui.screens.FindsScreen
import com.example.ui.screens.GuideDetailScreen
import com.example.ui.screens.GuidesScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.SavedScreen
import com.example.ui.theme.BlushTint
import com.example.ui.theme.HerFindsTheme

object HerFindsRoutes {
    const val HOME = "home"
    const val FINDS = "finds"
    const val GUIDES = "guides"
    const val SAVED = "saved"
    const val FIND_DETAIL = "find_detail/{findId}"
    const val GUIDE_DETAIL = "guide_detail/{guideId}"
    const val ARTICLE_DETAIL = "article_detail/{articleId}"
    const val ABOUT_LEGAL = "about_legal/{section}"

    fun findDetail(findId: String) = "find_detail/$findId"
    fun guideDetail(guideId: String) = "guide_detail/$guideId"
    fun articleDetail(articleId: String) = "article_detail/$articleId"
    fun aboutLegal(section: String) = "about_legal/$section"
}

private enum class TopTab(
    val route: String,
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {
    HOME(HerFindsRoutes.HOME, "Home", Icons.Filled.Home, Icons.Outlined.Home),
    FINDS(HerFindsRoutes.FINDS, "Finds", Icons.Filled.ShoppingBag, Icons.Outlined.ShoppingBag),
    GUIDES(HerFindsRoutes.GUIDES, "Guides", Icons.Filled.AutoStories, Icons.Outlined.AutoStories),
    SAVED(HerFindsRoutes.SAVED, "Saved", Icons.Filled.Bookmark, Icons.Outlined.BookmarkBorder)
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HerFindsTheme {
                HerFindsApp()
            }
        }
    }
}

@Composable
fun HerFindsApp(
    viewModel: HerFindsViewModel = viewModel()
) {
    val context = LocalContext.current
    val navController = rememberNavController()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val showTopChromeAndTabs = currentRoute in TopTab.entries.map { it.route }

    fun navigateToTopTab(route: String) {
        navController.navigate(route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val useRail = maxWidth >= 680.dp

        Row(modifier = Modifier.fillMaxSize()) {
            if (useRail && showTopChromeAndTabs) {
                NavigationRail(
                    containerColor = MaterialTheme.colorScheme.surface,
                    modifier = Modifier
                        .fillMaxHeight()
                        .statusBarsPadding()
                ) {
                    TopTab.entries.forEach { tab ->
                        val selected = currentRoute == tab.route
                        NavigationRailItem(
                            selected = selected,
                            onClick = { navigateToTopTab(tab.route) },
                            icon = {
                                TabIconWithBadge(
                                    tab = tab,
                                    selected = selected,
                                    savedCount = uiState.savedFindIds.size
                                )
                            },
                            label = { Text(tab.label) },
                            colors = NavigationRailItemDefaults.colors(
                                selectedIconColor = MaterialTheme.colorScheme.primary,
                                selectedTextColor = MaterialTheme.colorScheme.primary,
                                indicatorColor = BlushTint
                            ),
                            modifier = Modifier.testTag("nav_rail_${tab.route}")
                        )
                    }
                }
            }

            Scaffold(
                modifier = Modifier.weight(1f),
                contentWindowInsets = WindowInsets(0, 0, 0, 0),
                topBar = {
                    if (showTopChromeAndTabs) {
                        Column(modifier = Modifier.statusBarsPadding()) {
                            AnnouncementStrip(
                                onOpenWishlist = {
                                    openExternalUrl(
                                        context,
                                        HerFindsConstants.CURATED_AMAZON_WISHLIST_URL
                                    )
                                }
                            )
                            HerFindsTopHeader(
                                onSearchClick = { navigateToTopTab(HerFindsRoutes.FINDS) },
                                onAboutClick = {
                                    navController.navigate(HerFindsRoutes.aboutLegal("about"))
                                }
                            )
                        }
                    }
                },
                bottomBar = {
                    if (!useRail && showTopChromeAndTabs) {
                        NavigationBar(
                            containerColor = MaterialTheme.colorScheme.surface,
                            tonalElevation = 2.dp
                        ) {
                            TopTab.entries.forEach { tab ->
                                val selected = currentRoute == tab.route
                                NavigationBarItem(
                                    selected = selected,
                                    onClick = { navigateToTopTab(tab.route) },
                                    icon = {
                                        TabIconWithBadge(
                                            tab = tab,
                                            selected = selected,
                                            savedCount = uiState.savedFindIds.size
                                        )
                                    },
                                    label = { Text(tab.label) },
                                    colors = NavigationBarItemDefaults.colors(
                                        selectedIconColor = MaterialTheme.colorScheme.primary,
                                        selectedTextColor = MaterialTheme.colorScheme.primary,
                                        indicatorColor = BlushTint
                                    ),
                                    modifier = Modifier.testTag("nav_bar_${tab.route}")
                                )
                            }
                        }
                    }
                }
            ) { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = HerFindsRoutes.HOME,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    composable(HerFindsRoutes.HOME) {
                        HomeScreen(
                            uiState = uiState,
                            onExploreFinds = {
                                viewModel.clearCatalogFilters()
                                navigateToTopTab(HerFindsRoutes.FINDS)
                            },
                            onReadGuides = {
                                navigateToTopTab(HerFindsRoutes.GUIDES)
                            },
                            onCategoryClick = { category ->
                                viewModel.selectCategory(category)
                                navigateToTopTab(HerFindsRoutes.FINDS)
                            },
                            onFindClick = { findId ->
                                navController.navigate(HerFindsRoutes.findDetail(findId))
                            },
                            onToggleSave = viewModel::toggleSavedFind,
                            onGuideClick = { guideId ->
                                navController.navigate(HerFindsRoutes.guideDetail(guideId))
                            },
                            onArticleClick = { articleId ->
                                navController.navigate(HerFindsRoutes.articleDetail(articleId))
                            },
                            onOpenAboutLegal = { section ->
                                navController.navigate(HerFindsRoutes.aboutLegal(section))
                            },
                            onSubscribeNewsletter = viewModel::subscribeNewsletter,
                            onUnsubscribeNewsletter = viewModel::unsubscribeNewsletter
                        )
                    }

                    composable(HerFindsRoutes.FINDS) {
                        FindsScreen(
                            uiState = uiState,
                            onCategorySelected = viewModel::selectCategory,
                            onSearchQueryChange = viewModel::updateSearchQuery,
                            onToggleSavedOnly = viewModel::toggleSavedOnlyInCatalog,
                            onClearFilters = viewModel::clearCatalogFilters,
                            onFindClick = { findId ->
                                navController.navigate(HerFindsRoutes.findDetail(findId))
                            },
                            onToggleSave = viewModel::toggleSavedFind
                        )
                    }

                    composable(HerFindsRoutes.GUIDES) {
                        GuidesScreen(
                            uiState = uiState,
                            onGuideClick = { guideId ->
                                navController.navigate(HerFindsRoutes.guideDetail(guideId))
                            },
                            onArticleClick = { articleId ->
                                navController.navigate(HerFindsRoutes.articleDetail(articleId))
                            },
                            onOpenAboutChloe = {
                                navController.navigate(HerFindsRoutes.aboutLegal("about"))
                            }
                        )
                    }

                    composable(HerFindsRoutes.SAVED) {
                        SavedScreen(
                            uiState = uiState,
                            onFindClick = { findId ->
                                navController.navigate(HerFindsRoutes.findDetail(findId))
                            },
                            onToggleSave = viewModel::toggleSavedFind,
                            onBrowseFinds = { navigateToTopTab(HerFindsRoutes.FINDS) },
                            onAddCustomLink = viewModel::addCustomWishlistLink,
                            onRemoveCustomLink = viewModel::removeCustomWishlistLink
                        )
                    }

                    composable(
                        route = HerFindsRoutes.FIND_DETAIL,
                        arguments = listOf(navArgument("findId") { type = NavType.StringType })
                    ) { entry ->
                        val findId = entry.arguments?.getString("findId").orEmpty()
                        FindDetailScreen(
                            findId = findId,
                            isSaved = findId in uiState.savedFindIds,
                            onToggleSave = { viewModel.toggleSavedFind(findId) },
                            onBack = { navController.popBackStack() }
                        )
                    }

                    composable(
                        route = HerFindsRoutes.GUIDE_DETAIL,
                        arguments = listOf(navArgument("guideId") { type = NavType.StringType })
                    ) { entry ->
                        val guideId = entry.arguments?.getString("guideId").orEmpty()
                        GuideDetailScreen(
                            guideId = guideId,
                            savedFindIds = uiState.savedFindIds,
                            onToggleSave = viewModel::toggleSavedFind,
                            onFindClick = { findId ->
                                navController.navigate(HerFindsRoutes.findDetail(findId))
                            },
                            onBack = { navController.popBackStack() }
                        )
                    }

                    composable(
                        route = HerFindsRoutes.ARTICLE_DETAIL,
                        arguments = listOf(navArgument("articleId") { type = NavType.StringType })
                    ) { entry ->
                        val articleId = entry.arguments?.getString("articleId").orEmpty()
                        ArticleDetailScreen(
                            articleId = articleId,
                            savedFindIds = uiState.savedFindIds,
                            onToggleSave = viewModel::toggleSavedFind,
                            onFindClick = { findId ->
                                navController.navigate(HerFindsRoutes.findDetail(findId))
                            },
                            onBack = { navController.popBackStack() }
                        )
                    }

                    composable(
                        route = HerFindsRoutes.ABOUT_LEGAL,
                        arguments = listOf(navArgument("section") { type = NavType.StringType })
                    ) { entry ->
                        val section = entry.arguments?.getString("section") ?: "about"
                        AboutLegalScreen(
                            initialSection = section,
                            onBack = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun TabIconWithBadge(
    tab: TopTab,
    selected: Boolean,
    savedCount: Int
) {
    val icon = if (selected) tab.selectedIcon else tab.unselectedIcon
    if (tab == TopTab.SAVED && savedCount > 0) {
        BadgedBox(
            badge = {
                Badge(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ) {
                    Text(savedCount.toString())
                }
            }
        ) {
            Icon(imageVector = icon, contentDescription = tab.label)
        }
    } else {
        Icon(imageVector = icon, contentDescription = tab.label)
    }
}
