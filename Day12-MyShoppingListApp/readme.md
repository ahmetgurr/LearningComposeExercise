## Project Steps

-> Data class oluşturuyoruz: Bunlar ApiKey'imizin içerisinde yer alan datalar; Konum için longitude ve latitude ve geocodingi alıyoruz.

		**********************
-> LocationSelectionScreen ekranını oluşturuyoruz. Bu ekranda seçeceğimiz ekranda ne oalcağını ayarlıyoruz; Gmaps ekranı ve Select Buttonu yer alıyor.

		**********************
-> LocationViewModel oluşturuyoruz: Burada location verilerimizi güncellemek Özel değişkeni genel değişkene aktarıyoruz, daha sonra fonksiyon ile lokasyonu _location'a atıyoruz. 

		**********************
-> LocationUtils oluşturuyoruz: Burada kullanıcının konum güncellemelerini almak ve konum güncellemelerini başlatmak, izni olup olmadığını kontrol etmek için kullanılır. Bu LocationUtils sınıfını direkt projelerden alabiliriz, aynı.

		**********************
-> Shopping listin içerisine val requestPermissionLauncher'ı ekliyoruz. burada izin varsa gir yoksa hata ver gibi durumlar gösteriliyor. 

		**********************
->Interface oluşturuyoruz: data classın içerisinde işimize yarar olanı alıp Interface oluşturuyoruz.

		**********************
-> Ojbect oluşturuyoruz(RetrofitClient): BASE_URL'imizi veriyoruz daha sonra burada "create" fonksiyonumuzu oluşturuyoruz. Bunun içerisinde baseUrl(içerisine BASE_URL veriyoruz), addConverterFactory ve build'imizi atıyoruz. Daha sonra return ile create ediyoruz. 

		**********************
-> Create fonksiyonunu Önceden oluşturmuş olduğumuz viewModel'imizde kullanarak aktifleştirmek istiyoruz. 
Özel değişkeni genel değişkene aktarıyoruz, daha sonra bu oluşturduğumuzu almak için aynı sayfada bir fonksiyon oluşturuyoruz. fun fetchAddress adında fonksiyon oluşturuyoruz ve bunu try cathc a atıyoruz ve içerisinde coroutine başlatıyoruz, bunun sebebi ise suspend fun çağırmak istiyorsak bunu bir coroutine içerisinde çağırmamız gerekir.
try kımsında coroutine başlatıp Interface'mizdeki getAddressFromCoordinates fonksiyonunu çağırıyoruz ve gerekli olan latlng ve apiKey'imizi veriyoruz çunku getAddressFromCoordinates içerisinde bunlar var. Son olarak ise en başta genel değişkene atadığımız değere atıyoruz. 
		**********************
