Feature: Login surveyor activity
	Scenario: input username and password surveyor
		When logout akun administrator
		And Menampilkan form login surveyor
		And Mengisi username surveyor
		And Mengisi password surveyor
		And Login ke sistem JCB surveyor
		Then Muncul pesan selamat datang user