## TOBETO Java - React Fullstack Rent a Car Projesi
- <a href="https://github.com/rdvngrsy/rent-a-car/commit/9e5b0f5e4deb8411a5d190ee337be09f39d4af44">**17/11/2023 Workshop:**</a>

Spring ve pgAdmin kurulumları yapıldı. Ardından spring ile 'code first' prensibi doğrultusunda entitys, tablolar, kolonlar ve tabloların ilişkisi  oluşturuldu. Sonrasında database bağlantısı gerçekleştirildi.

- <a href="https://github.com/rdvngrsy/rent-a-car/commit/fb9ac2f17e59646e138f0528be6acfaf6e48e1c6">**20/11/2023 Workshop:**</a>

Katmanlı mimariye uyum sağlamak için **'repositories'** ve **'controllers'** packages oluşturuldu. Repositories içerisinde her bir entity için Interface oluşturuldu ve içlerinde **'JpaRepository'** sayesinde database bağlantıları daha kolay ve işlevsel hale getirildi.

Sonrasında her bir entity için **'controllers'** katmanı oluşturuldu ve ekleme, düzenleme, silme, id' ye göre getirme işlemleri için methodlar yazıldı.

**Swagger UI** kurulumu gerçekleştirildi. Böylece API erişimi daha kolay hale getirildi.  

- <a href="https://github.com/rdvngrsy/rent-a-car/commit/6a168a5f7f218b2b6dc5a4150d968d03d261d2d3">**22/11/2023 Workshop:**</a>

Önceki workshop' da oluşturduğum **'controllers'** katmanını  Request - Response pattern uyumlu hale getirdim. Bunun için **'dtos'** adında bir package oluşturdum. Her bir entity için Request - Response işlemlerini gerçekleştirdim. Böylece controller katmanında direk entityler ile bağlantı kurmak yerine, neyi gösterip neyi göstermeyeceğimi ayarlayabildiğim bir yapı oluşturdum.

- <a href="https://github.com/rdvngrsy/rent-a-car/commit/f70cb85e18a89bd91af39178e24f76a015f48eff">**24/11/2023 Workshop:**</a>

Bu workshop' da **'services'** katmanını projeme ekledim. Bu projede kötü koddan iyi koda doğru gidildiği için  **'controllers'** katmanında yazdığım kontrolleri **'services'** katmanında yazmam gerektiğini öğrendim. Bunun için Service adıyla Interfaceler oluşturdum. Bu interfaceleri, Manager adıyla java classlarına implement ettim. Sonrasında controllerda yazdığım kodları **'services'** katmanına aktarmış oldum. Böylece kullanıcıyı entities ile direk teması aradan kaldırmış oldum. Bunu da Manager classlarında mapping yaparak sağladım.  

- <a href="">**04/12/2023 Workshop:**</a>

Bu workshop' da projeme her bir entitynin repositorysinde **'Derived'** ve **'JPQL Query'** sorgu örnekleri ekledim. Sonrasında **'services'** katmanında değişikliklerini uyguladım ve **'controllers'** katmanında CRUD işlemlerini uyguladım. Böylece **'Derived'** ve **'JPQL Query'** sorgularını öğrenmiş oldum.
