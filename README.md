# 🍽️ Restaurante App - Navigation Component

Aplicativo Android de restaurante desenvolvido com **Kotlin DSL**, implementando **Navigation Component**, **BottomNavigation**, **Safe Args** e boas práticas de arquitetura.

## 📁 Localização do Projeto

```
C:\Users\Italo\CascadeProjects\RestaurantNavApp
```

## 🎯 Funcionalidades Implementadas

### ✅ Componentes de Navegação
- **Navigation Component** - Navegação entre fragments
- **Navigation Controller** - Controle de navegação
- **Navigation UI** - Integração com BottomNavigation e ActionBar
- **Safe Args** - Passagem segura de dados entre fragments (Parcelable)

### 📱 Fragments Implementados

1. **HomeFragment** 
   - Exibe os 6 pratos mais populares (ordenados por rating)
   - RecyclerView com LinearLayoutManager
   - Navegação para detalhes com Safe Args

2. **MenuFragment**
   - Menu completo com todos os pratos
   - Filtro por categorias usando ChipGroup
   - RecyclerView com GridLayoutManager (2 colunas)
   - Contador de pratos disponíveis

3. **FavoritesFragment**
   - Lista de pratos favoritos
   - Empty state quando não há favoritos
   - Sistema de favoritos persistente

4. **ProfileFragment**
   - Informações do usuário
   - Estatísticas em cards (Total de Pratos, Favoritos, Categorias)
   - Design moderno com Material Cards

5. **DishDetailFragment**
   - Detalhes completos do prato
   - Recebe objeto Dish via Safe Args (Parcelable)
   - Botões de favoritar e fazer pedido
   - Navegação de volta

## 🍽️ Conteúdo Real

O app contém **18 pratos reais** com:
- Nomes descritivos
- Descrições completas
- Preços realistas (R$ 18,50 a R$ 89,90)
- Emojis representativos
- Ratings (avaliações de 4.4 a 4.9)
- **11 categorias**: Pizza, Massas, Hambúrgueres, Japonês, Saudável, Saladas, Mexicano, Fast Food, Carnes, Asiático, Sobremesas

## 🔧 Tecnologias Utilizadas

- **Kotlin** - Linguagem principal
- **Kotlin DSL** - Build scripts (Gradle)
- **Navigation Component** - Navegação
- **Safe Args** - Passagem segura de argumentos
- **View Binding** - Binding de views
- **Parcelize** - Serialização de dados
- **Material Design 3** - UI Components
- **RecyclerView** - Listas
- **CardView** - Cards
- **BottomNavigationView** - Navegação inferior

## 🚀 Como Executar

1. Abra o projeto no **Android Studio**
2. Sincronize o Gradle (Sync Project with Gradle Files)
3. Execute no emulador ou dispositivo físico
4. MinSDK: 24 (Android 7.0)
5. TargetSDK: 34 (Android 14)

## 📋 Navegação Implementada

```
HomeFragment → DishDetailFragment
MenuFragment → DishDetailFragment
FavoritesFragment → DishDetailFragment
ProfileFragment (sem navegação filha)
```

### Bottom Navigation
- 🏠 Home
- 📋 Menu
- ❤️ Favoritos
- 👤 Perfil

## 🎯 Requisitos Atendidos

✅ BottomNavigation com 4 itens  
✅ 5 Fragments (Home, Menu, Favorites, Profile, Detail)  
✅ Navigation Component configurado  
✅ Navigation Controller implementado  
✅ Navigation UI integrado  
✅ Safe Args com Parcelable  
✅ Conteúdo real e completo  
✅ Kotlin DSL (build.gradle.kts)  
✅ Layout responsivo e moderno  

## 👨‍💻 Desenvolvedor

Italo - italo@discente.ifpe.edu.br

## 📄 Licença

Projeto educacional - IFPE
