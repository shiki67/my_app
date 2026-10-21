package io.mmaltsev.vkeducation.presentation.applist

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart

val hardcodedApps = listOf(
    AppDetails(1, "Инструменты", Icons.Filled.Build, "Набор полезных утилит для повседневных задач", "Утилиты"),
    AppDetails(2, "Почта", Icons.Filled.Email, "Удобный клиент для работы с несколькими ящиками", "Коммуникации"),
    AppDetails(3, "Звонки", Icons.Filled.Call, "Быстрые звонки и история вызовов", "Коммуникации"),
    AppDetails(4, "Календарь", Icons.Filled.DateRange, "Планируйте встречи и получайте напоминания", "Продуктивность"),
    AppDetails(5, "Карты", Icons.Filled.Place, "Навигация и поиск мест рядом с вами", "Путешествия"),
    AppDetails(6, "Покупки", Icons.Filled.ShoppingCart, "Списки покупок и сравнение цен в магазинах", "Шопинг"),
    AppDetails(7, "Умный дом", Icons.Filled.Home, "Управление устройствами в вашем доме", "Образ жизни"),
    AppDetails(8, "Настройки", Icons.Filled.Settings, "Тонкая настройка системы и приложений", "Система"),
)