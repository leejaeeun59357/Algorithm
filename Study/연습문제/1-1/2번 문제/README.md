## 문제 설명
여름을 맞아 가족들과 함께 해수욕장을 방문했습니다.

코로나로 인해서 많은 사람이 각자의 파라솔 아래에서 마스크를 쓰고 둘러앉아 모래 뺏기 게임을 하고 있습니다.

흥민이와 흥민이의 누나는 ```num```kg의 모래를 쌓아두고 게임을 시작합니다.

모래성 중앙의 깃발은 ```1```kg 미만이 되면 쓰러집니다.

아래와 같은 조건으로 모래 뺏기 게임을 진행한다고 합니다.

- 조건
    - 흥민이와 누나는 모두 필승법을 알고 있다고 가정합니다.
    - 한 사람이 한 번에 가져갈 수 있는 모래의 양은 ```1```, ```2```, ```3```kg 중 하나입니다.
    - 흥민이는 자신이 필승법을 사용할 수 있게, 항상 먼저 게임을 시작합니다.
    - 자신의 차례에 깃발을 넘어뜨리면 패배합니다. 즉, 본인 차례에 모래가 1kg 남아있는 경우 어쩔 수 없이 패배합니다.
    - 흥민이가 ```num```kg의 모래로 시작해서 승리할 수 있는지 여부를 ```true``` 또는 ```false```의 논리값으로 출력하는 프로그램을 구현하세요.

## 입력 형식

- ```num```: 시작 모래의 kg 수의 정수 값

## 출력 형식
- 흥민이가 이길 수 있는지 여부를 논리 값으로 반환

## 제약 사항
- ```0 < num <= 100000```

## 입출력 예시
- 예시1
    - 입력
    - num = 5
    - 출력: false
    - 설명: 아래와 같이, 흥민이가 이길 수 있는 방법이 없다.
    - 흥민이가 1kg을 가져갈 경우, 누나가 3kg를 가져가고, 흥민이 차례에 1kg이 남으므로 흥민이가 패배한다.
    - 흥민이가 2kg을 가져갈 경우, 누나가 2kg을 가져가고, 흥민이 차례에 1kg이 남으므로 흥민이가 패배한다.
    - 흥민이가 3kg을 가져갈 경우, 누나가 1kg을 가져가고, 흥민이 차례에 1kg이 남으므로 흥민이가 패배한다.
- 예시2
    - 입력
    - num = 4
    - 출력: true
    - 설명: 아래와 같이, 흥민이가 반드시 이기는 수가 있다.
    - 흥민이가 3kg을 가져갈 경우, 누나에게 1kg이 남으므로 흥민이가 승리한다.