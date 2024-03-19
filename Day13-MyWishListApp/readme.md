##Project Steps

-> AppBar oluşturuyoruz ve fun AppBarView ile başlık ve geri butonu tanımlıyoruz.
			***************
-> wish data class oluşturuyoruz burada wishlerimizin alacağı ozellikler(id, title, description) ve DummyWish olarak üç adet wish oluşturuyoruz.
			***************
-> HomeView oluşturuyoruz ve fun HomeView  ile fun WishItem eklıyoruz. 
-fun WishItem ile bir card oluşturuyoruz ve bunların düzeninin belirliyoruz ve Wish olan data classımızı ve click özelliği ekliyoruz, bunu Scaffold -> LazyColumn içerisinde DummyWish ->wishList i ekliyoruz listelenıyor. 
-fun HomeView içerisinde Scaffold oluşturuyoruz bu iskelettir.(Scaffold, genellikle kullanıcı arayüzünü oluşturmak için kullanılan bir yapıdır ve genellikle bir AppBar, FloatingActionButton, Drawer ve BottomNavigationBar gibi yaygın bileşenleri içerir.)
			***************
-> sealed class Screen ekliyoruz bu da navigationlarımızda geçiş yapacağımız adları içeriyor. 
			***************
-> WishViewModel oluşturduk -> WishViewModel: ViewModel(){}
			***************
-> Navigation oluşturduk. fun Navigation ile NavHostları oluşturduk geçiş ekranlarını verdik. 
			***************
-> AddEditDetailView oluşturduk. fun AddEditDetailView, fun WishTextField ekledik. AddEditDetailView içerisinde Scaffold iskeletini ekledik ve AddEditDetailView içerisinde tasarımı oluşturduk(WishTextField yaptığımız OutlinedTextField i içine eklemiş olduk)
			***************
-> WishViewModel'imizin içerisine giriş kutusunun değerini tutmak için değerlerimizi MutableState oluşturup mutableStateOf'a ekledik. ve function olarak aşağıda bunları tanımladık. Bu oluşturudğumuz fonksiyonları ise değerlere atadık ve WishTextField içerisinde bunları çağırdık. 
			***************
-> Geri butonu: "navController.navigateUp()" ise AddEditDetailView -> Scaffold'ın özelliği olarak ekledik. Bu özellik gelinen sayfaya geri dönülmesini sağlıyor. 
			***************
-> Geçiş özellikleri: Geçiş için ise HomeView ve AddEditDetailView içerisine özellik olarak (viewModel: WishViewModel, navController: NavController) ekliyoruz. 
HomeView da navController.navigate(Screen.AddScreen.route) ile ikinci sayfaya, AddEditDetailView sayfasında ise geri gelmek için navController.navigateUp() kullanıyoruz. 
(bu özellikler ise Navigation sayfasında içerisine verdiğimiz özellikleri eklemiş oluyoruz. )
			***************
