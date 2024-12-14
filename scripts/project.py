all_llms = [
    "ai21Jamba15Mini",
    "ai21Jamba15Large",
    "claude35Haiku",
    "claude35Sonnet",
    "gpt35Turbo", 
    "gpt4oMini", 
    "gpt4o", 
    "gpto1Mini",
    "metaAI",
    "mistralSmall",
    "mistralLarge",  
]

all_prompts = [
    "black",
    "grey",
    "white"
]

all_packages = [
    "anagrams", 
    "binaryTree", 
    "MedianSortedArrays", 
    "orangesRotting", 
    "NQueens", 
    "trityp", 
    "RegularExpressionMatching", 
    "cloneGraph", 
    "numIslands"
]

all_classes = {
    "Anagrams": {
        "package": "anagrams",
        "difficulty": "medium"
    },
    "BinaryTree": {
        "package": "binaryTree",
        "difficulty": "medium"
    },
    "CloneGraph": {
        "package": "cloneGraph",
        "difficulty": "medium"
    },
    "Median": {
        "package": "MedianSortedArrays",
        "difficulty": "hard"
    },
    "Nqueens": {
        "package": "NQueens",
        "difficulty": "hard"
    },
    "NumIslands": {
        "package": "numIslands",
        "difficulty": "medium"
    },
    "OrangesRot": {
        "package": "orangesRotting",
        "difficulty": "medium"
    },
    "Regular": {
        "package": "RegularExpressionMatching",
        "difficulty": "hard"
    },
    "Trityp": {
        "package": "trityp",
        "difficulty": "easy"
    }
}

from dataclasses import dataclass, field, asdict
from typing import Dict, List


@dataclass
class JacocoCounter:
    name: str
    total: int
    covered: int
    missed: int
    coverage: float

    def to_dict(self):
        return asdict(self)

    @classmethod
    def from_dict(cls, data: dict):
        return cls(**data)


@dataclass
class JacocoMetrics:
    counters: Dict[str, JacocoCounter] = field(default_factory=dict)

    def to_dict(self):
        return {"counters": {name: counter.to_dict() for name, counter in self.counters.items()}}

    @classmethod
    def from_dict(cls, data: dict):
        counters = {name: JacocoCounter.from_dict(counter) for name, counter in data["counters"].items()}
        return cls(counters=counters)


@dataclass
class PitMutator:
    name: str
    tests_run: int
    killed: int
    survived: int
    detected: int
    undetected: int
    no_coverage: int

    def to_dict(self):
        return asdict(self)

    @classmethod
    def from_dict(cls, data: dict):
        return cls(**data)


@dataclass
class PitMetrics:
    totals: Dict[str, int]  # For overall totals like tests_run, killed, etc.
    mutators: Dict[str, PitMutator] = field(default_factory=dict)

    def to_dict(self):
        return {
            "totals": self.totals,
            "mutators": {name: mutator.to_dict() for name, mutator in self.mutators.items()}
        }

    @classmethod
    def from_dict(cls, data: dict):
        mutators = {name: PitMutator.from_dict(mutator) for name, mutator in data["mutators"].items()}
        return cls(totals=data["totals"], mutators=mutators)


@dataclass
class StaticMetrics:
    lines_of_code: int
    num_tests: int
    num_assertions: int

    def to_dict(self):
        return asdict(self)

    @classmethod
    def from_dict(cls, data: dict):
        return cls(**data)


@dataclass
class TestMetrics:
    total_tests: int
    tests_passed: int
    tests_failed: int
    tests_skipped: int

    def to_dict(self):
        return asdict(self)

    @classmethod
    def from_dict(cls, data: dict):
        return cls(**data)


@dataclass
class TestClass:
    name: str
    package: str
    llm: str
    prompt: str
    metrics: Dict[str, object]  # Includes static, test, jacoco, and pit metrics.

    def to_dict(self):
        return {
            "name": self.name,
            "package": self.package,
            "llm": self.llm,
            "prompt": self.prompt,
            "metrics": {
                key: value.to_dict() if hasattr(value, "to_dict") else value
                for key, value in self.metrics.items()
            }
        }

    @classmethod
    def from_dict(cls, data: dict):
        metrics = {
            "static": StaticMetrics.from_dict(data["metrics"]["static"]),
            "test": TestMetrics.from_dict(data["metrics"]["test"]),
            "jacoco": JacocoMetrics.from_dict(data["metrics"]["jacoco"]),
            "pit": PitMetrics.from_dict(data["metrics"]["pit"]),
        }
        return cls(
            name=data["name"],
            package=data["package"],
            llm=data["llm"],
            prompt=data["prompt"],
            metrics=metrics
        )


@dataclass
class Project:
    test_classes: Dict[str, TestClass] = field(default_factory=dict)
    schema_version: str = "1.0"
    generated_at: str = ""

    def to_dict(self):
        return {
            "schema_version": self.schema_version,
            "generated_at": self.generated_at,
            "project": {
                "test_classes": {name: test_class.to_dict() for name, test_class in self.test_classes.items()}
            }
        }

    @classmethod
    def from_dict(cls, data: dict):
        test_classes = {name: TestClass.from_dict(test_class) for name, test_class in data["project"]["test_classes"].items()}
        return cls(
            test_classes=test_classes,
            schema_version=data["schema_version"],
            generated_at=data["generated_at"]
        )
