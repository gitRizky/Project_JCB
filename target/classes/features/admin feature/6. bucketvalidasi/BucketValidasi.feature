Feature: Bucket Validasi
Scenario: Testing Bucket Validasi
		When Menampilkan Data Validation
		And Drop down list yang berisi nama area
		And Menampilkan filter data berdasarkan nama area
		And Mencari Data merchant name
		And Menampilkan Detail Visit
		And Menampilkan Pop up Validate form
#		And Menyimpan data validate
		And Tidak menyimpan data validate
		And Mencari Data merchant name untuk return
		And Menampilkan Detail Visit untuk return
		And Menampilkan Pop up return form
		And Mengisi Note return
		And Menyimpan data return
#		And Tidak menyimpan data return
		And Mencari Data merchant name untuk reject
		And Menampilkan Detail Visit untuk reject
		And Menampilkan Pop up reject form
		And Mengisi Note reject
		And Menyimpan data reject
#		Then Tidak menyimpan data reject