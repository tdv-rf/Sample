# Simple demo project

- Как даггер собирает все зависимости? Почему он может заинжектить в любой модуль?
- Почему даггер не может инжекттить в ContentProvider? Когда инициализируется даггер а когда провайдер?
- Базовые компоненты даггера Component Subcomponent Module (OldDaggerComponent)
- Провайдить через @Inject constructor
- Провайдить через @Provides module
- ViewModelComponent. Попробовать заинжектить во фрагмент из внутри модуля ViewModelComponent (Предложить покопаться в исходниках чтобы понять почему не получилось) А куда получится?
- Scope Singleton ViewModelScope FragmentScope... Как он работает и время его жизни
- Пример с перемещением в профайл фрагмент с удалением из бек стека и без. Как будут вести себя вьюмодели
- Dagger Provider<T> -лейзи
