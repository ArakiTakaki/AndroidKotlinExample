# KotlinExample

Javaを使用していたがKotlinでプロジェクトを進めたくなったのでとりあえずはKotlinでの発見などを書き込んでいくプロジェクト

## Getter/Setterに関して

```kt
class Templ{
    var id = 0
        set(value){
            if ( 0 <= value)
                field = value
        }
    var name = ""
    var honzon = ""
    var shushi = ""
    var address = ""
    var url = ""
    var note = ""
}
```

- getter/setterを明示的に記述する必要は無い。
- setterでValidationをかける際は `id`のように記述する


## inner class

[inner class sample](https://github.com/ArakiTakaki/AndroidKotlinExample/blob/master/app/src/main/java/kotorin70455/saigoku/an25/hal/local/saigokukotlin70455/TempleListActivity.kt#L38)

44行目を参照

`Intent(this@TempleListActivity,TempleEditActivity::class.java)`

このように this を指定する際、inner classと明示的に宣言しないと参照することができないので注意（他にももっと簡略化できるが省略）


