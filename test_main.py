from main import get_hello

def test_get_hello_returns_hello_world():
    assert get_hello() == "Hello, World!"
